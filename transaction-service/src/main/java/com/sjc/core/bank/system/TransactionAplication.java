package com.sjc.core.bank.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TransactionAplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionAplication.class, args);
	}

}
