package com.example.bankapp.DataAccess.Repository;

import com.example.bankapp.DataAccess.DataBase.DataBase;
import com.example.bankapp.DataAccess.Models.User;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UserRepository {

    public void createUser(Context context, User user ){
        DataBase admin = new DataBase(context,"DataBase",null,1);
        SQLiteDatabase DB = admin.getWritableDatabase();
        ContentValues register = new ContentValues();
        register.put("idUser",user.getIdUser());
        register.put("name",user.getName());
        register.put("lastName",user.getLastName());
        register.put("password", user.getPassword());
        register.put("account", user.getAccount());
        register.put("email",user.getEmail());
        register.put("prev_password",user.getPrevPassword());
        register.put("passwordDate",user.getPasswordDate().getTime());
        DB.insert("user",null,register);
        DB.close();

    }
    public User getUserByID(Context context,int id){
        DataBase admin = new DataBase(context,"DataBase",null,1);
        SQLiteDatabase DB = admin.getWritableDatabase();
        Cursor row = DB.rawQuery("SELECT * FROM  user WHERE idUser ="+id,null);
        User user = new User(row);
        DB.close();
        return user;
    }

    public void updateUser(Context context,User user){
        DataBase admin = new DataBase(context,"DataBase",null,1);
        SQLiteDatabase DB = admin.getWritableDatabase();
        ContentValues register = new ContentValues();
        register.put("idUser",user.getIdUser());
        register.put("name",user.getName());
        register.put("lastName",user.getLastName());
        register.put("password", user.getPassword());
        register.put("account", user.getAccount());
        register.put("email",user.getEmail());
        register.put("prev_password",user.getPrevPassword());
        register.put("passwordDate",user.getPasswordDate().getTime());
        DB.update("user",register,"idUser ="+user.getIdUser(),null);
        DB.close();
    }

    public  void  deleteUser(Context context, int idUser){
        DataBase admin = new DataBase(context,"DataBase",null,1);
        SQLiteDatabase DB = admin.getWritableDatabase();
        DB.delete("user","idUser ="+idUser,null);
        DB.close();
    }

}
