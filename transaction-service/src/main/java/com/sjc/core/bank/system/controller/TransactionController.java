package com.sjc.core.bank.system.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sjc.core.bank.system.model.dto.TransactionDto;
import com.sjc.core.bank.system.service.ITransactionService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/transaction/")
@RequiredArgsConstructor
@Slf4j
public class TransactionController {

	private final ITransactionService transactionService;

	@PostMapping("/deposite")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> depositeTransaction(@RequestBody TransactionDto transactionDto) {
		log.info("Received Transaction controller depoiste request: {}", transactionDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(transactionService.depositeTransaction(transactionDto));

	}

	@PostMapping("/widthraw")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> widthrawTransaction(@RequestBody TransactionDto transactionDto) {
		log.info("Received Transaction controller widthraw request: {}", transactionDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(transactionService.widthrawTransaction(transactionDto));

	}
}
