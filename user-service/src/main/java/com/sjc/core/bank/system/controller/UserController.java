package com.sjc.core.bank.system.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sjc.core.bank.system.model.dto.AccountDto;
import com.sjc.core.bank.system.model.dto.CustomerDto;
import com.sjc.core.bank.system.service.IAccountService;
import com.sjc.core.bank.system.service.ICustomerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/userservice/user")
@RequiredArgsConstructor
public class UserController {

	private final ICustomerService customerService;

	private final IAccountService accountService;

	@PostMapping("/customer")
	public ResponseEntity<?> createCustomer(@RequestBody CustomerDto cusotmerDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomer(cusotmerDto));
	}

	@PostMapping("/account")
	public ResponseEntity<?> createAccount(@RequestBody AccountDto accountDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(accountService.createAccount(accountDto));
	}

}
