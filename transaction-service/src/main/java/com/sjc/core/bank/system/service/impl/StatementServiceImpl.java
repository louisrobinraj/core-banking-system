package com.sjc.core.bank.system.service.impl;

import org.springframework.stereotype.Service;

import com.sjc.core.bank.system.model.dto.StatementDto;
import com.sjc.core.bank.system.service.IStatementService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StatementServiceImpl implements IStatementService {

	@Override
	public String geneteStatement(StatementDto statementDto) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("Error occured " + e.getMessage());
		}
		return "Slow service invoked successfully";
	}

}
