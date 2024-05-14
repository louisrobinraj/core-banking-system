package com.sjc.core.bank.system.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {

	private String type;
	private double amount;
	private Integer accountNumber;
	private String branch;
	private String ifscCode;
	private String balance;
}
