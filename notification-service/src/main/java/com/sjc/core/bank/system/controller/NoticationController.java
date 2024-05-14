package com.sjc.core.bank.system.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/notification")
@RequiredArgsConstructor
public class NoticationController {

	Logger logger = LogManager.getLogger(NoticationController.class);

	@Autowired
	private AsyncService asyncService;

	@GetMapping("/email")
	public ResponseEntity<?> sendEmail() throws InterruptedException {
		logger.info("send maain execution started..");
//		asyncService.doAction();
		return ResponseEntity.ok("Email send successfully");
	}

	@GetMapping("/all-operation")
	public ResponseEntity<?> multiOperation() throws InterruptedException {
		asyncService.multiOperation();
		return null;
	}

	@GetMapping("/orders")
	public void getOrders() {
		logger.info("OrderController:placeOrder persist order request {}");
		logger.info("OrderController:placeOrder response from service {}");
	}

	@GetMapping("/orders/{id}")
	public void getOrder(@PathVariable int id) {
		logger.info("OrderController:getOrder fetch order by id {}", id);
	}
}
