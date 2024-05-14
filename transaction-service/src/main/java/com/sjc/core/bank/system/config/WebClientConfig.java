package com.sjc.core.bank.system.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    WebClient webClient() {
		return WebClient.builder().build();
	}

    @Bean
    @LoadBalanced
    WebClient.Builder loadBalancedWebClientBuilder() {
		return WebClient.builder();
	}

    @Bean
    RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
