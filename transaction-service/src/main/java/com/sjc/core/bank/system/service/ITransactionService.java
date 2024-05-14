package com.sjc.core.bank.system.service;

import com.sjc.core.bank.system.model.dto.TransactionDto;

public interface ITransactionService {
	public TransactionDto widthrawTransaction(TransactionDto transactionDto);
	public TransactionDto depositeTransaction(TransactionDto transactionDto);
}
