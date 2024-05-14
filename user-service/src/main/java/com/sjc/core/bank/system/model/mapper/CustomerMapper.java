package com.sjc.core.bank.system.model.mapper;

import org.springframework.beans.BeanUtils;

import com.sjc.core.bank.system.model.dto.CustomerDto;
import com.sjc.core.bank.system.model.entity.Customer;

public class CustomerMapper extends BaseMapper<Customer, CustomerDto> {
	@Override
	public Customer convertToEntity(CustomerDto dto, Object... args) {
		Customer entity = new Customer();
		if (dto != null) {
			BeanUtils.copyProperties(dto, entity);
		}
		return entity;
	}

	@Override
	public CustomerDto convertToDto(Customer entity, Object... args) {
		CustomerDto dto = new CustomerDto();
		if (entity != null) {
			BeanUtils.copyProperties(entity, dto);
		}
		return dto;
	}
}