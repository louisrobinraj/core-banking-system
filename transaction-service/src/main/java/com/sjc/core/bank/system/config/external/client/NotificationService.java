package com.sjc.core.bank.system.config.external.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "notification-service")
public interface NotificationService {
	@GetMapping("/api/v1/notification/email")
	ResponseEntity<String> sendSms();
}