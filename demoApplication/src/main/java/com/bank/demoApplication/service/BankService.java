package com.bank.demoApplication.service;


import com.bank.demoApplication.RequestModel.AddAmountModel;
import com.bank.demoApplication.entity.Account;

import java.util.List;
import java.util.Optional;

public interface BankService {
    public Optional<Account> creditAmount(AddAmountModel addAmount) throws Exception;

    public Optional<Account> withdrawAmount(AddAmountModel addAmount) throws Exception;

    public List<Optional<Account>> transferAmount(AddAmountModel addAmountModel, int id) throws  Exception;

    }
