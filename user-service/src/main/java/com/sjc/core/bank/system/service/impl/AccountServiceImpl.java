package com.sjc.core.bank.system.service.impl;

import org.springframework.stereotype.Service;

import com.sjc.core.bank.system.model.dto.AccountDto;
import com.sjc.core.bank.system.model.entity.Account;
import com.sjc.core.bank.system.model.mapper.AccountMapper;
import com.sjc.core.bank.system.repository.AccountRepository;
import com.sjc.core.bank.system.service.IAccountService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements IAccountService {

	private final AccountRepository accountRepository;

	private AccountMapper accountMapper = new AccountMapper();

	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		Account account = accountRepository.save(accountMapper.convertToEntity(accountDto));
		return accountMapper.convertToDto(account);
	}

}
