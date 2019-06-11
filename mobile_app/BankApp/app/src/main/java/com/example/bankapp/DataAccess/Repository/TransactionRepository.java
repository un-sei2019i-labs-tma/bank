package com.example.bankapp.DataAccess.Repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.bankapp.DataAccess.DataBase.DataBase;
import com.example.bankapp.DataAccess.Models.Account;
import com.example.bankapp.DataAccess.Models.Transaction;

import java.util.Date;

public class TransactionRepository {

    //a
    public void createTransaction (Context context,Transaction transaction){
        DataBase admin = new DataBase(context,"DataBase",null,1);
        SQLiteDatabase DB = admin.getWritableDatabase();
        ContentValues register = new ContentValues();
        register.put("account_origin",transaction.getAccountOrigin());
        register.put("account_end",transaction.getAccountEnd());
        register.put("amount",transaction.getAmount());
        register.put("date",transaction.getDate().getTime());
        register.put("transaction_type",transaction.getTransactionType());
        DB.insert("transactions",null,register);
        DB.close();
    }
    //b
    public void createTransaction (Context context, Account accountOrigin, Account accountEnd, double Amount){
        Date date = new Date(System.currentTimeMillis());
        Transaction transaction=new Transaction(42, accountOrigin.getIdAccount(), accountEnd.getIdAccount(), Amount, date, 0);
        this.createTransaction(context, transaction);
    }
    //c
    public void createTransaction (Context context, int accountOrigin, int accountEnd, double Amount){
        Date date = new Date(System.currentTimeMillis());
        Transaction transaction=new Transaction(42, accountOrigin, accountEnd, Amount, date, 0);
        this.createTransaction(context, transaction);
    }

    public Transaction getTransactionByID(Context context, int id ){

        DataBase admin = new DataBase(context,"DataBase",null,1);
        SQLiteDatabase DB = admin.getWritableDatabase();
        Cursor row = DB.rawQuery("SELECT * FROM transactions WHERE id_transaction ="+id,null);
        Transaction transaction = new Transaction(row);
        DB.close();
        return transaction;
    }

    public  void  updateTransaction(Context context, Transaction transaction){
        DataBase admin = new DataBase(context,"DataBase",null,1);
        SQLiteDatabase DB = admin.getWritableDatabase();
        ContentValues register = new ContentValues();
        register.put("account_origin",transaction.getAccountOrigin());
        register.put("account_end",transaction.getAccountEnd());
        register.put("amount",transaction.getAmount());
        //atenciontime
        register.put("date",transaction.getDate().getTime());
        register.put("transaction_type",transaction.getTransactionType());
        DB.update("transactions",register,"id_transaction ="+transaction.getIdTransaction(),null);
        DB.close();

    }

    public  void deleteTransactionByID(Context context,int id){
        DataBase admin = new DataBase(context,"DataBase",null,1);
        SQLiteDatabase DB = admin.getWritableDatabase();
        DB.delete("transactions","id_transaction ="+id,null);
        DB.close();


    }

    public void deleteTransaction(Context context , Transaction transaction){
        DataBase admin = new DataBase(context,"DataBase",null,1);
        SQLiteDatabase DB = admin.getWritableDatabase();
        DB.delete("transactions","id_transaction ="+transaction.getIdTransaction(),null);
        DB.close();
    }
}
