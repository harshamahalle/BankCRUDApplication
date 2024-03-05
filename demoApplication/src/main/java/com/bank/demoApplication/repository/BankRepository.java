package com.bank.demoApplication.repository;

import com.bank.demoApplication.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Account,Integer> {
}
