package com.sjc.core.bank.system.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.sjc.core.bank.system.config.external.client.NotificationService;
import com.sjc.core.bank.system.model.dto.TransactionDto;
import com.sjc.core.bank.system.model.dto.entity.Transaction;
import com.sjc.core.bank.system.model.dto.mapper.TransactionMapper;
import com.sjc.core.bank.system.repository.TransactionRepository;
import com.sjc.core.bank.system.service.ITransactionService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class TransactionServiceImpl implements ITransactionService {

	private final TransactionRepository transactionRepository;
	private final NotificationService notificationService;
	private final WebClient.Builder loadBalancedWebClientBuilder;
	private final TransactionMapper transactionMapper = new TransactionMapper();

	@Override
	@CircuitBreaker(name = "NotificationService", fallbackMethod = "fallbackMethod")
	public TransactionDto widthrawTransaction(TransactionDto transactionDto) {
		log.info("widthraw Transaction");
		Transaction transaction = transactionRepository.save(transactionMapper.convertToEntity(transactionDto));
		ResponseEntity<String> sms = notificationService.sendSms();
		String mes = loadBalancedWebClientBuilder.build().get()
				.uri("http://notification-service/api/v1/notification/email").retrieve().bodyToMono(String.class)
				.block();
		System.out.println(mes);
		return transactionMapper.convertToDto(transaction);
	}

	@Override
	@CircuitBreaker(name = "NotificationService", fallbackMethod = "fallbackMethod")
	public TransactionDto depositeTransaction(TransactionDto transactionDto) {
		log.info("Deposite Transaction");
		Transaction transaction = transactionRepository.save(transactionMapper.convertToEntity(transactionDto));
		ResponseEntity<String> sms = notificationService.sendSms();
		String response = loadBalancedWebClientBuilder.build().get()
				.uri("http://notification-service/api/v1/notification/email").retrieve().bodyToMono(String.class)
				.block();
		log.info("API Response", response);
		return transactionMapper.convertToDto(transaction);
	}

	public TransactionDto fallbackMethod(Throwable throwable) {
		System.out.println("Oops! Sometime went wrong, Please order after some time");
		return TransactionDto.builder().build();
	}

}
