package com.example.bankapp.BusinessLogic;

import com.example.bankapp.DataAccess.Models.Account;

public class SendMoney {

    public void send(Account origin, Account end, double amount){

    }

    public void operation(Account origin,Account end, double amount){
                origin.setBalance(origin.getBalance()-amount);
                end.setBalance(end.getBalance()+amount);
    }

    public void substrac(){


    }

    public void add(){


    }





}
