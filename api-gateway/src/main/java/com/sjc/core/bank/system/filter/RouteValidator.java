package com.sjc.core.bank.system.filter;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Predicate;

@Component
public class RouteValidator {

	public static final List<String> openApiEndpoints = List.of("/register", "/token", "validate", "/eureka");

	public Predicate<ServerHttpRequest> isSecured = request -> openApiEndpoints.stream().noneMatch(uri -> {
		return request.getURI().getPath().contains(uri);
	});

}