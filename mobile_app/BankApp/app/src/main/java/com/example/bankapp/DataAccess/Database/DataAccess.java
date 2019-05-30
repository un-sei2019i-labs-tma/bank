package com.example.bankapp.DataAccess.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataAccess extends SQLiteOpenHelper {


    public DataAccess(Context context, String name,SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DBUtilities.CREATE_USER_TABLE);
        db.execSQL(DBUtilities.CREATE_ADMIN_TABLE);
        db.execSQL(DBUtilities.CREATE_ACCOUNT_TABLE);
        db.execSQL(DBUtilities.CREATE_ACCOUNT_TRANSACTION_TABLE);
        db.execSQL(DBUtilities.CREATE_TRANSACTIONS_TABLE);
        db.execSQL(DBUtilities.CREATE_TRANSACTION_TYPE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS user");
        db.execSQL("DROP TABLE IF EXISTS admin");
        db.execSQL("DROP TABLE IF EXISTS account");
        db.execSQL("DROP TABLE IF EXISTS account_transaction");
        db.execSQL("DROP TABLE IF EXISTS transactions");
        db.execSQL("DROP TABLE IF EXISTS transaction_type");
        onCreate(db);

    }


}
