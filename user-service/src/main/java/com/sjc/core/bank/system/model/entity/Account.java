package com.sjc.core.bank.system.model.entity;

import com.sjc.core.bank.system.model.dto.AccountType;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "account")
public class Account extends BaseEntity {
	
	private Integer accountNumber;
	private String branch;
	private String ifscCode;
	private AccountType accountType;
	private double balanceAmount;
}