package com.example.bankapp.DataAccess.Models;

import android.database.Cursor;

import java.util.Date;

public class Transaction {


    private int idTransaction;
    private int accountOrigin;
    private int accountEnd;
    private double amount;
    private Date date;
    private int transactionType;

    public Transaction(int idTransaction, int accountOrigin, int accountEnd, double amount, Date date, int transactionType) {
        this.idTransaction = idTransaction;
        this.accountOrigin = accountOrigin;
        this.accountEnd = accountEnd;
        this.amount = amount;
        this.date = date;
        this.transactionType = transactionType;
    }



    public Transaction(Cursor row){
        if (row.moveToFirst()){
            this.idTransaction = row.getInt(0);
            this.accountOrigin = row.getInt(1);
            this.accountEnd = row.getInt(2);
            this.amount = row.getDouble(3);
            this.date = new Date(row.getLong(4));
            this.transactionType = row.getInt(5);
        }
    }


    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    public int getIdTransaction() {
        return idTransaction;
    }


    public void setAccountOrigin(int accountOrigin) {
        this.accountOrigin = accountOrigin;
    }

    public int getAccountOrigin() {
        return accountOrigin;
    }


    public void setAccountEnd(int accountEnd) {
        this.accountEnd = accountEnd;
    }

    public int getAccountEnd() {
        return accountEnd;
    }


    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public void setTransactionType(int transactionType) {
        this.transactionType = transactionType;
    }

    public int getTransactionType() {
        return transactionType;
    }
}