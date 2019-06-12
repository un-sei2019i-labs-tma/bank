package com.example.bankapp.DataAccess.Repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.bankapp.DataAccess.DataBase.DataBase;
import com.example.bankapp.DataAccess.Models.Account;


public class AccountRepository {
    public void createAccount(Context context, Account account){
        DataBase admin = new DataBase(context,"DataBase",null,1);
        SQLiteDatabase DB = admin.getWritableDatabase();
        ContentValues register = new ContentValues();
        register.put("id_account", account.getIdAccount());
        register.put("balance",account.getBalance());
        DB.insert("account",null,register);
        DB.close();

    }

    public Account getAccount(Context context, int id){
        DataBase admin = new DataBase(context,"DataBase",null,1);
        SQLiteDatabase DB = admin.getWritableDatabase();
        Cursor row = DB.rawQuery("SELECT * FROM  account WHERE id_account ="+id,null);
        Account account = new Account(row);
        DB.close();
        return account;
    }

    public void updateAccount(Context context, Account account){
        DataBase admin = new DataBase(context,"DataBase",null,1);
        SQLiteDatabase DB = admin.getWritableDatabase();
        ContentValues register = new ContentValues();
        register.put("id_account",account.getIdAccount());
        register.put("balance",account.getBalance());
        DB.update("account",register,"id_account ="+account.getIdAccount(),null);
        DB.close();
    }

    public void deleteAccountByID(Context context , int  idAccount){
        DataBase admin = new DataBase(context,"DataBase",null,1);
        SQLiteDatabase DB = admin.getWritableDatabase();
        DB.delete("account","id_account ="+idAccount,null);
        DB.close();
    }
}
