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

    public static final String CREATE_ADMIN_TABLE = "CREATE TABLE manager (" +
            "id_manager INTEGER (10) PRIMARY KEY," +
            "name TEXT NOT NULL ," +
            "last_name TEXT NOT NULL ," +
            "password TEXT (6) NOT NULL )";


    public static final String CREATE_ACCOUNT_TABLE = "CREATE TABLE account (" +
            "id_account INTEGER (10) PRIMARY KEY," +
            "balance DOUBLE (10) NOT NULL )";


    //public static final String CREATE_ACCOUNT_TRANSACTION_TABLE = "CREATE TABLE account_transaction (" +
    //        "accountId_account INTEGER (10)  ," +
    //        "transactionId_transaction INTEGER (10) , " +
    //        "FOREIGN KEY (accountId_account) REFERENCES account(id_account)," +
    //        "FOREIGN KEY (transactionId_transaction) REFERENCES transactions(id_transaction)" +
    //        "PRIMARY KEY (accountId_account, transactionId_transaction ))";


    public static final String CREATE_TRANSACTIONS_TABLE = "CREATE TABLE transactions (" +
            "id_transaction INTEGER  PRIMARY KEY AUTOINCREMENT," +
            "account_origin INTEGER (10) ," +
            "account_end INTEGER (10) NOT NULL," +
            "amount DOUBLE NOT NULL," +
            "date DATE NOT NULL," +
            "transaction_type INTEGER (10) NOT NULL, " +
            "FOREIGN KEY (account_origin) REFERENCES account(id_account)"+
            "FOREIGN KEY (account_end) REFERENCES account(id_account)" +
            "FOREIGN KEY (transaction_type) REFERENCES transaction_type(idTransactionType))";


    public static final String CREATE_TRANSACTION_TYPE_TABLE = "CREATE TABLE transaction_type (" +
            "idTransactionType INTEGER (10) PRIMARY KEY," +
            "type TEXT NOT NULL)";

    public static final  String ADD_TEST_USER = "()";



}