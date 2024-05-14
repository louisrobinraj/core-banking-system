package com.sjc.core.bank.system.model.dto.mapper;

import org.springframework.beans.BeanUtils;

import com.sjc.core.bank.system.model.dto.TransactionDto;
import com.sjc.core.bank.system.model.dto.entity.Transaction;

public class TransactionMapper extends BaseMapper<Transaction, TransactionDto> {
	@Override
	public Transaction convertToEntity(TransactionDto dto, Object... args) {
		Transaction entity = new Transaction();
		if (dto != null) {
			BeanUtils.copyProperties(dto, entity);
		}
		return entity;
	}

	@Override
	public TransactionDto convertToDto(Transaction entity, Object... args) {
		TransactionDto dto = new TransactionDto();
		if (dto != null) {
			BeanUtils.copyProperties(dto, dto);
		}
		return dto;
	}
}