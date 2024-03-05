package com.bank.demoApplication.service;

import com.bank.demoApplication.RequestModel.AddAmountModel;
import com.bank.demoApplication.entity.Account;
import com.bank.demoApplication.repository.BankRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BankServiceImpl implements BankService {
    private BankRepository bankRepository;

    @Autowired
    public BankServiceImpl(BankRepository bankRepository){
        this.bankRepository=bankRepository;
    }

    public Optional<Account> creditAmount(AddAmountModel addAmount) throws Exception{
        int id  = addAmount.getId();
        long amount = addAmount.getAmount();
        Optional<Account> account= bankRepository.findById(id);

        if(account.isEmpty()){
            throw new Exception("Account not present");
        }
        //Crediting to account
        account.get().setAmount(account.get().getAmount()+amount);

        return account;
    }

    public Optional<Account> withdrawAmount(AddAmountModel addAmount) throws Exception{
        int id  = addAmount.getId();
        long amount = addAmount.getAmount();
        Optional<Account> account= bankRepository.findById(id);


        if(account.isEmpty()){
            throw new Exception("Account not present");
        }

        //withdrawing from account
        if(account.get().getAmount()>=amount) {
            account.get().setAmount(account.get().getAmount() - amount);
        }
        else{
            throw new Exception("Insufficient Balance");
        }

        return account;
    }

    public List<Optional<Account>> transferAmount(AddAmountModel addAmountModel, int id) throws  Exception{
        List<Optional<Account>> list= new ArrayList<>();

        //Id of account from which amount will br transfer
        int withdrawId = addAmountModel.getId();

        //Amount to be transfer
        long amountToBeCredited = addAmountModel.getAmount();

        //Account from which amount will get transfer
        Optional<Account> withDrawAccount = bankRepository.findById(withdrawId);

        //Current balance of account from which amount will be deducted
        long balance = withDrawAccount.get().getAmount();

        if(balance>=amountToBeCredited)
        {
            //withdraw from account where acoountId= withDrawId
            Optional<Account> withDrawAccountReturned= withdrawAmount(addAmountModel);

            //credit to account where accountId= id
            //we need to create addAmountModel object
            AddAmountModel obj= new AddAmountModel(id,amountToBeCredited);

            Optional<Account> creditAccount = creditAmount(obj);
            list.add(withDrawAccountReturned);
            list.add(creditAccount);
        }
        else{
            throw new Exception("Insufficient Balance in account  "+withdrawId);
        }

        return list;


    }

}
