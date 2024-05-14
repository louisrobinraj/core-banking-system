package com.sjc.core.bank.system.service;

import com.sjc.core.bank.system.model.dto.StatementDto;

public interface IStatementService {

	public String geneteStatement(StatementDto statementDto);

}
