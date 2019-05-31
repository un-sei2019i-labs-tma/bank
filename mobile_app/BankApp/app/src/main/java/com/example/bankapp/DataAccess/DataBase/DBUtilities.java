package com.example.bankapp.DataAccess.DataBase;

public class DBUtilities {

    //create User table
    public static final String CREATE_USER_TABLE = "CREATE TABLE user (" +
            "idUser INTEGER PRIMARY KEY ," +
            "name TEXT NOT NULL ," +
            "lastName TEXT NOT NULL ," +
            "password INTEGER (6) NOT NULL ," +
            "account INTEGER (10) NOT NULL ," +
            "email TEXT NOT NULL ," +
            "prev_password INTEGER (6) ," +
            "passwordDate DATE)";

    public static final String CREATE_ADMIN_TABLE = "CREATE TABLE admin (" +
            "id_admin INTEGER (10) PRIMARY KEY," +
            "name TEXT NOT NULL ," +
            "last_name TEXT NOT NULL ," +
            "password TEXT (6) NOT NULL ," +
            "email TEXT NOT NULL)";


    public static final String CREATE_ACCOUNT_TABLE = "CREATE TABLE account (" +
            "id_account INTEGER (10) PRIMARY KEY," +
            "balance DOUBLE (10) NOT NULL )";


    public static final String CREATE_ACCOUNT_TRANSACTION_TABLE = "CREATE TABLE account_movement (" +
            "accountId_account INTEGER (10) NOT NULL," +
            "transactionId_movement INTEGER (10) NOT NULL )";


    public static final String CREATE_MOVEMENT_TABLE = "CREATE TABLE movement (" +
            "id_transaction INTEGER (10) PRIMARY KEY," +
            "account_origin INTEGER (10) NOT NULL," +
            "account_end INTEGER (10) NOT NULL," +
            "date DATE NOT NULL," +
            "transaction_type INTEGER (10) NOT NULL )";


    public static final String CREATE_MOVEMENT_TYPE_TABLE = "CREATE TABLE movement_type (" +
            "idTransactionType INTEGER (10) PRIMARY KEY," +
            "type TEXT NOT NULL)";

    public static final  String GET_USER_BY_ID = "SELECT ";





}
