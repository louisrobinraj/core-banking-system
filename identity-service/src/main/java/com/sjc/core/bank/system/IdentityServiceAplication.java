package com.sjc.core.bank.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class IdentityServiceAplication {

	public static void main(String[] args) {
		SpringApplication.run(IdentityServiceAplication.class, args);
	}

}
