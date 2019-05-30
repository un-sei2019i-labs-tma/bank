package com.example.bankapp.Models;

public class Admin {

    private int idAdmin;
    private String name;

    public Admin(){

    }

    public Admin(int idAdmin, String name, String lastName, String password, int account, String email) {
        this.idAdmin = idAdmin;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.account = account;
        this.email = email;
    }

    private String lastName;
    private String password;
    private int account;
    private String email;

    public int getIdAmin() {
        return idAdmin;
    }

    public void setIdAmin(int idAmin) {
        this.idAdmin = idAmin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
