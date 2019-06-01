package com.example.bankapp.DataAccess.Models;

import android.database.Cursor;

public class TransactionType {


    private int idTransactionType;
    private String Type;



    public TransactionType(int idTransactionType, String type) {
        this.idTransactionType=idTransactionType;
        this.Type = type;
    }

    public TransactionType(Cursor row){
        if (row.moveToFirst()){
            this.idTransactionType = row.getInt(0);
            this.Type = row.getString(1);
        }
    }

    public int getIdTransactionType() {
        return idTransactionType;}

    public void setIdTransactionType(int idTransactionType) {
        this.idTransactionType = idTransactionType;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getType() {
        return Type;
    }

}