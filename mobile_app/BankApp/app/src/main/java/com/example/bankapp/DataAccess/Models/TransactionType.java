package com.example.bankapp.DataAccess.Models;

public class TransactionType {

    private String Type;

    public TransactionType(String type) {
        Type = type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getType() {
        return Type;
    }

}