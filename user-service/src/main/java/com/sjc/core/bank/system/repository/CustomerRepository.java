package com.sjc.core.bank.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sjc.core.bank.system.model.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
