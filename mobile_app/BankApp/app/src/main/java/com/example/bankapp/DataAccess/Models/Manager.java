package com.example.bankapp.DataAccess.Models;

public class Manager {

    private int idManager;
    private String name;

    public Manager(){

    }

    public Manager(int idManager, String name, String lastName, String password) {
        this.idManager = idManager;
        this.name = name;
        this.lastName = lastName;
        this.password = password;

    }

    private String lastName;
    private String password;
    private int account;
    private String email;

    public int getIdManager() {
        return idManager;
    }

    public void setIdManager(int idManager) {
        this.idManager = idManager;
    }

    public String getName() { return name; }

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

}
