package com.sjc.core.bank.system.model.dto;

import com.sjc.core.bank.system.model.entity.Address;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerDto {

	private Integer id;
	private String name;
	private Address address;
	private String occupation;
	private Status status;

}
