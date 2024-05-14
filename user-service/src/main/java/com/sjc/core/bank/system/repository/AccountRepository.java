package com.sjc.core.bank.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sjc.core.bank.system.model.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}
