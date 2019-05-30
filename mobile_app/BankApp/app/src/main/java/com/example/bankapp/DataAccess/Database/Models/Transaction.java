package com.example.bankapp.Models;

import java.util.Date;

public class Transaction {


    private int idTransaction;
    private int accountOrigin;
    private int accountEnd;
    private double mount;
    private Date date;
    private int transactionType;

    public Transaction(int idTransaction, int accountOrigin, int accountEnd, double mount, Date date, int transactionType) {
        this.idTransaction = idTransaction;
        this.accountOrigin = accountOrigin;
        this.accountEnd = accountEnd;
        this.mount = mount;
        this.date = date;
        this.transactionType = transactionType;
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


    public void setMount(double mount) {
        this.mount = mount;
    }

    public double getMount() {
        return mount;
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