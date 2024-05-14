package com.sjc.core.bank.system.controller;

import java.util.Date;
import java.util.concurrent.CompletableFuture;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sjc.core.bank.system.config.external.client.NotificationService;
import com.sjc.core.bank.system.model.dto.StatementDto;
import com.sjc.core.bank.system.model.dto.TransactionDto;
import com.sjc.core.bank.system.service.IStatementService;

import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/transaction/")
@RequiredArgsConstructor
public class StatementController {

	private final IStatementService statementService;
	private final NotificationService notificationService;

	@PostMapping(value = "/statment-time-limiter")
	@TimeLimiter(name = "NotificationService", fallbackMethod = "timeLimiterFallBack")
	public CompletableFuture<String> getAccountStatement(@RequestBody StatementDto statementDto) {
		return CompletableFuture.supplyAsync(() -> statementService.geneteStatement(statementDto));
	}

	public CompletableFuture<String> timeLimiterFallBack(Throwable ex) {
		return CompletableFuture.completedFuture("Timeout exception - No further calls are accepted");
	}

	@GetMapping("/statment-rate-limit")
	@RateLimiter(name = "NotificationService", fallbackMethod = "fallBackRateLimit")
	public ResponseEntity<String> getMovieDetailsWithFallback(String movieId) {
		ResponseEntity<String> sms = notificationService.sendSms();
		System.out.println(sms);
		return ResponseEntity.status(HttpStatus.OK).body("Ok");
	}

	@GetMapping("/statment-retry")
	@Retry(name = "NotificationService", fallbackMethod = "fallbackRetry")
	public ResponseEntity<String> createOrder() {
		System.out.println(
				"date time " + new Date().getHours() + "-" + new Date().getMinutes() + "-" + new Date().getSeconds());
		ResponseEntity<String> sms = notificationService.sendSms();
		System.out.println(sms);
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

	public TransactionDto fallbackMethod(Throwable throwable) {
		System.out.println("Oops! Sometime went wrong, Please order after some time");
		return TransactionDto.builder().build();
	}

	public ResponseEntity<String> fallbackRetry(Exception e) {
		return new ResponseEntity<String>("Item service is down", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private ResponseEntity<String> fallBackRateLimit(RequestNotPermitted requestNotPermitted) {
		return new ResponseEntity<String>(
				"order service does not permit further calls " + requestNotPermitted.getMessage(),
				HttpStatus.TOO_MANY_REQUESTS);
	}

}