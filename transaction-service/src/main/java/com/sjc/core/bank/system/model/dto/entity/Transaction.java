package com.sjc.core.bank.system.model.dto.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "transaction")
public class Transaction extends BaseEntity {

	private String type;
	private double amount;
	private Integer accountNumber;
	private String branch;
	private String ifscCode;
	private String balance;
}
