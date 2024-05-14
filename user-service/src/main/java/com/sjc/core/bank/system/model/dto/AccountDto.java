package com.sjc.core.bank.system.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountDto {

	private Integer accountNumber;
	private String branch;
	private String ifscCode;
	private AccountType accountType;
	private double balanceAmount;

}
