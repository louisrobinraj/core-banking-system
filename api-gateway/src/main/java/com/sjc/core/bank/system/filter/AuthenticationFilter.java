package com.sjc.core.bank.system.filter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.SerializationUtils;
import org.springframework.web.client.RestTemplate;

import com.sjc.core.bank.system.exception.ErrorResponseDto;
import com.sjc.core.bank.system.util.JwtTokenUtil;

import reactor.core.publisher.Flux;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

	private static final String JWT_PARSE_URL = "IDENTITY-SERVICE";

	@Autowired
	private RouteValidator validator;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private RestTemplate restTemplate;

	public AuthenticationFilter() {
		super(Config.class);
	}

	@Override
	public GatewayFilter apply(Config config) {
		return ((exchange, chain) -> {
			if (validator.isSecured.test(exchange.getRequest())) {
				// header contains token or not
				if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
					throw new RuntimeException("missing authorization header");
				}

				String authToken = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
				if (authToken != null && authToken.startsWith("Bearer ")) {
					authToken = authToken.substring(7);
				}
				try {

					Boolean isValid = restTemplate.getForObject(
							"http://" + JWT_PARSE_URL + "/api/v1/identity/auth/validate?token=" + authToken,
							Boolean.class);
					System.out.println(isValid);
					/* jwtTokenUtil.validateToken(authToken); */
				} catch (Exception ex) {
					List<String> details = new ArrayList<>();
					details.add(ex.getLocalizedMessage());
					ErrorResponseDto error = new ErrorResponseDto(new Date(), HttpStatus.UNAUTHORIZED.value(),
							"UNAUTHORIZED", details, exchange.getRequest().getURI().toString());
					ServerHttpResponse response = exchange.getResponse();
					byte[] bytes = SerializationUtils.serialize(error);
					DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(bytes);
					response.writeWith(Flux.just(buffer));
					response.setStatusCode(HttpStatus.UNAUTHORIZED);
					return response.setComplete();
				}
			}
			return chain.filter(exchange);
		});
	}

	public static class Config {

	}
}