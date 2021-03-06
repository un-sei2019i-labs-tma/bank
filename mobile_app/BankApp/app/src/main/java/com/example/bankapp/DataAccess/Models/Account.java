package com.example.bankapp.DataAccess.Models;

import android.database.Cursor;

public class Account {

    private int idAccount;
    private double balance;


    public Account(int idAccount, int balance) {
        this.idAccount = idAccount;
        this.balance = balance;
    }


    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public int getIdAccount() {
        return idAccount;
    }


    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }


    public Account(Cursor row) {
        if (row.moveToFirst()){
            this.idAccount = row.getInt(0);
            this.balance = row.getDouble(1);
        }

    }
}
