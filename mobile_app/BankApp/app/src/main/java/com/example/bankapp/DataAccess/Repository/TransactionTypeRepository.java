package com.example.bankapp.DataAccess.Repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.bankapp.DataAccess.DataBase.DataBase;
import com.example.bankapp.DataAccess.Models.TransactionType;


public class TransactionTypeRepository {

    public void createTransaccionType(Context context,TransactionType transactionType){
        DataBase admin = new DataBase(context,"DataBase",null,1);
        SQLiteDatabase DB = admin.getWritableDatabase();
        ContentValues register = new ContentValues();
        register.put("idTransactionType",transactionType.getIdTransactionType());
        register.put("type",transactionType.getType());
        DB.insert("transaction_type",null,register);
        DB.close();

    }

    public TransactionType geteTransacctionByID(Context context, int id){
        DataBase admin = new DataBase(context,"DataBase",null,1);
        SQLiteDatabase DB = admin.getWritableDatabase();
        Cursor row = DB.rawQuery("SELECT * FROM  transaction_type WHERE idTransactionTyp ="+id,null);
        TransactionType transactionType = new TransactionType(row);
        DB.close();
        return transactionType;
    }

    public void updateTransacctionType(Context context, TransactionType transactionType){
        DataBase admin = new DataBase(context,"DataBase",null,1);
        SQLiteDatabase DB = admin.getWritableDatabase();
        ContentValues register = new ContentValues();
        register.put("idTransactionType",transactionType.getIdTransactionType());
        register.put("type",transactionType.getType());
        DB.update("idTransactionType",register,"idTransactionType ="+transactionType.getType(),null);
        DB.close();
    }

    public void deleteTransacctionType(Context context , TransactionType transactionType){
        DataBase admin = new DataBase(context,"DataBase",null,1);
        SQLiteDatabase DB = admin.getWritableDatabase();
        DB.delete("transaction_type","idTransactionType ="+transactionType.getType(),null);
        DB.close();
    }

    public void deleteTransacctionTypeByID(Context context , int  idtransactionType){
        DataBase admin = new DataBase(context,"DataBase",null,1);
        SQLiteDatabase DB = admin.getWritableDatabase();
        DB.delete("transaction_type","idTransactionType ="+idtransactionType,null);
        DB.close();
    }
}
