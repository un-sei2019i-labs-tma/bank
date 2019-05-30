package com.example.bankapp.DataAccess.Models;

import java.util.Date;

public class User {
    private int idUser;
    private String name;
    private String lastName;
    private String password;
    private int account;
    private String email;
    private String prevPassword;
    protected Date passwordDate;

    public User(){

    }

    public User(int idUser, String name, String lastName, String password, int account, String email, String prevPassword, Date passwordDate){
        this.idUser = idUser;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.account = account;
        this.email = email;
        this.prevPassword = prevPassword;
        this.passwordDate= passwordDate;
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


    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
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


    public void setPrevPassword(String prevPassword) {
        this.prevPassword = prevPassword;
    }

    public String getPrevPassword() {
        return prevPassword;
    }


    public void setPasswordDate(Date passwordDate) {
        this.passwordDate = passwordDate;
    }

    public Date getPasswordDate() {
        return passwordDate;
    }

}