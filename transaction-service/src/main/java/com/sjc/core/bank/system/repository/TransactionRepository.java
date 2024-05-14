package com.sjc.core.bank.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sjc.core.bank.system.model.dto.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}
