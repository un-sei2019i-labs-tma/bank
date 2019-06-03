package com.example.bankapp.DataAccess.Repository;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.bankapp.DataAccess.DataBase.DataBase;
import com.example.bankapp.DataAccess.Models.Manager;


public class ManagerRepository {
    public void createUser(Context context, Manager manager ){
        DataBase admin = new DataBase(context,"DataBase",null,1);
        SQLiteDatabase DB = admin.getWritableDatabase();
        ContentValues register = new ContentValues();
        register.put("idManager",manager.getIdManager());
        register.put("name", manager.getName());
        register.put("lastName", manager.getLastName());
        register.put("password", manager.getPassword());
        DB.insert("manager",null,register);
        DB.close();
    }

    public void updateManager(Context context,Manager manager){
        DataBase admin = new DataBase(context,"DataBase",null,1);
        SQLiteDatabase DB = admin.getWritableDatabase();
        ContentValues register = new ContentValues();
        register.put("idManager",manager.getIdManager());
        register.put("name",manager.getName());
        register.put("lastName",manager.getLastName());
        register.put("password", manager.getPassword());
        DB.update("manager",register,"idManager ="+manager.getIdManager(),null);
        DB.close();
    }

    public  void  deleteManager(Context context, Manager manager){
        DataBase admin = new DataBase(context,"DataBase",null,1);
        SQLiteDatabase DB = admin.getWritableDatabase();
        DB.delete("manager","idManager ="+manager.getIdManager(),null);
        DB.close();
    }

}


