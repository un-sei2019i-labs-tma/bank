package com.example.bankapp.DataAccess.Models;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    private int idUser;
    private String name;
    private String lastName;
    private int password;
    private int account;
    private String email;
    private int prevPassword;
    protected Date passwordDate;

    public User(){

    }

    public User(int idUser, String name, String lastName, int password, int account, String email, int prevPassword, Date passwordDate){
        this.idUser = idUser;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.account = account;
        this.email = email;
        this.prevPassword = prevPassword;
        this.passwordDate= passwordDate;
    }

    public User(int id ,String name ){
        this.name=name;
        this.idUser=id;
    }

    public User(Cursor row) {
        if (row.moveToFirst()){
            this.idUser = row.getInt(0);
            this.name = row.getString(1);
            this.lastName = row.getString(2);
            this.password = row.getInt(3);
            this.account = row.getInt(4);
            this.email = row.getString(5);
            this.prevPassword = row.getInt(6);
            this.passwordDate = new Date(row.getLong(7));
        }
    }


    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdUser() {
        return idUser;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }


    public void setPassword(int password) {
        this.password = password;
    }

    public int getPassword() {
        return password;
    }


    public void setAccount(int account) {
        this.account = account;
    }

    public int getAccount() {
        return account;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }


    public void setPrevPassword(int prevPassword) {
        this.prevPassword = prevPassword;
    }

    public int getPrevPassword() {
        return prevPassword;
    }


    public void setPasswordDate(Date passwordDate) {
        this.passwordDate = passwordDate;
    }

    public Date getPasswordDate() {
        return passwordDate;
    }

}