package com.example.bankapp.BusinessLogic;

import android.content.Context;

import com.example.bankapp.DataAccess.Models.Account;
import com.example.bankapp.DataAccess.Models.Transaction;
import com.example.bankapp.DataAccess.Repository.AccountRepository;
import com.example.bankapp.DataAccess.Repository.TransactionRepository;

public class SendMoneyController {

    public int send(Context context, int origin, int end, double amount){

        AccountRepository accountRepository = new AccountRepository();
        TransactionRepository transactionRepository = new TransactionRepository();

        Account account1 = accountRepository.getAccount(context,origin);
        if(!isValidBalance(account1,amount)) return 1;
        Account account2 =accountRepository.getAccount(context,end);
        if(account2 == null) return 2;
        operation(account1,account2,amount);
        accountRepository.updateAccount(context,account1);
        accountRepository.updateAccount(context,account2);
        transactionRepository.createTransaction(context,account1,account2,amount);
        return 0;
    }

    public void operation(Account origin,Account end, double amount){
                substrac(origin,amount);
                add(end,amount);
    }

    public void substrac(Account account, double amount){
            account.setBalance(account.getBalance()-amount);
    }

    public void add(Account account, double amount){
            account.setBalance(account.getBalance()+amount);
    }

    private boolean isValidBalance (Account account, double amount){
        if(account.getBalance()<amount){
            return false;
        }else{
            return true;
        }
    }





}
