package com.sjc.core.bank.system.service.impl;

import org.springframework.stereotype.Service;

import com.sjc.core.bank.system.model.dto.CustomerDto;
import com.sjc.core.bank.system.model.entity.Customer;
import com.sjc.core.bank.system.model.mapper.CustomerMapper;
import com.sjc.core.bank.system.repository.CustomerRepository;
import com.sjc.core.bank.system.service.ICustomerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements ICustomerService {

	private final CustomerRepository customerRepository;

	private CustomerMapper customerMapper = new CustomerMapper();

	@Override
	public CustomerDto createCustomer(CustomerDto cusotmerDto) {
		Customer customer = customerRepository.save(customerMapper.convertToEntity(cusotmerDto));

		return customerMapper.convertToDto(customer);
	}

}
