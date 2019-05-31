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
            "passwordDate DATE ," +
            "FOREIGN KEY (account) REFERENCES account(id_account))";

    public static final String CREATE_ADMIN_TABLE = "CREATE TABLE admin (" +
            "id_admin INTEGER (10) PRIMARY KEY," +
            "name TEXT NOT NULL ," +
            "last_name TEXT NOT NULL ," +
            "password TEXT (6) NOT NULL ," +
            "email TEXT NOT NULL)";


    public static final String CREATE_ACCOUNT_TABLE = "CREATE TABLE account (" +
            "id_account INTEGER (10) PRIMARY KEY," +
            "balance DOUBLE (10) NOT NULL )";


    public static final String CREATE_ACCOUNT_TRANSACTION_TABLE = "CREATE TABLE transaction (" +
            "accountId_account INTEGER (10) PRIMARY KEY," +
            "transactioId_transaction INTEGER (10) PRIMARY KEY " +
            "FOREIGN KEY (accountId_account) REFERENCES account(id_account)" +
            "FOREIGN KEY (transactionId_transaction) REFERENCES transactions(id_transaction))";


    public static final String CREATE_MOVEMENT_TABLE = "CREATE TABLE movement (" +
            "id_transaction INTEGER (10) PRIMARY KEY," +
            "account_origin INTEGER (10) NOT NULL" +
            "account_end INTEGER (10) NOT NULL" +
            "date DATA() NOT NULL" +
            "transaction_type INTEGER (10) NOT NULL " +
            "FOREIGN KEY (transactionType) REFERENCES transaction_type(idTransactionType))";


    public static final String CREATE_TRANSACTION_TYPE_TABLE = "CREATE TABLE transaction_type (" +
            "idTransactionType INTEGER (10) PRIMARY KEY," +
            "type TEXT NOT NULL)";

    public static final  String ADD_TEST_USER = "()";



}