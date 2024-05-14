package com.sjc.core.bank.system.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "address")
public class Address extends BaseEntity {

	private String landmark;
	private String city;
	private String state;
	private String country;
	private String zip;

}