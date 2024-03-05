package com.bank.demoApplication.controller;

import com.bank.demoApplication.RequestModel.AddAmountModel;
import com.bank.demoApplication.entity.Account;
import com.bank.demoApplication.service.BankServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/acc")
public class BankController {

    private BankServiceImpl BankServiceImpl;

    @Autowired
    public BankController(BankServiceImpl BankServiceImpl)
    {
        this.BankServiceImpl = BankServiceImpl;
    }

    //RestApi end point to credit amount to the requested account
    @PutMapping("/credit")
    public Optional<Account> creditAmount(@RequestBody AddAmountModel addAmount) throws Exception{
        Optional<Account> account = BankServiceImpl.creditAmount(addAmount);
        return account;
    }

    //RestApi end point to withdraw amount to the requested account
    @PutMapping("/withdraw")
    public Optional<Account> withdrawAmount(@RequestBody AddAmountModel addAmount) throws Exception{
        Optional<Account> account = BankServiceImpl.withdrawAmount(addAmount);
        return account;
    }

    //RestApi end point to transfer amount from one account to another
    @PutMapping("/transfer/{id}")
    public List<Optional<Account>> transferAmount(@RequestBody AddAmountModel addAmount, @PathVariable int id) throws Exception{
        List<Optional<Account>> accounts= BankServiceImpl.transferAmount(addAmount,id);
        return accounts;
    }

}

