package com.sjc.core.bank.system.model.mapper;

import org.springframework.beans.BeanUtils;

import com.sjc.core.bank.system.model.dto.AccountDto;
import com.sjc.core.bank.system.model.entity.Account;

public class AccountMapper extends BaseMapper<Account, AccountDto> {
	@Override
	public Account convertToEntity(AccountDto dto, Object... args) {
		Account entity = new Account();
		if (dto != null) {
			BeanUtils.copyProperties(dto, entity);
		}
		return entity;
	}

	@Override
	public AccountDto convertToDto(Account account, Object... args) {
		AccountDto dto = new AccountDto();
		if (account != null) {
			BeanUtils.copyProperties(account, dto);
		}
		return dto;
	}
}