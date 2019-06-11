package com.example.bankapp.Presentation;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bankapp.BusinessLogic.LoginController;
import com.example.bankapp.DataAccess.DataBase.DataBase;
import com.example.bankapp.DataAccess.Models.Account;
import com.example.bankapp.DataAccess.Models.User;
import com.example.bankapp.DataAccess.Repository.AccountRepository;
import com.example.bankapp.DataAccess.Repository.UserRepository;
import com.example.bankapp.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText mTextUsername;
    EditText mTextPassword;
    Button mButtonLogin;
    private  static  final  String USER = "user";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        // create test use
        //SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        User user = new User(1,"pepito","perez",654321,12,"test@test.com",000000,date );
        User user2 = new User(2,"pepita","pereza",123456,21,"test@test.com",000000,date );
        UserRepository repo= new UserRepository();
        repo.createUser(this,user);
        repo.createUser(this,user2);
        Account account = new Account(12,1500);
        Account account2 = new Account(21,2300);
        AccountRepository accountRepository = new AccountRepository();
        accountRepository.createAccount(this,account);
        accountRepository.createAccount(this,account2);
        mTextUsername = (EditText) findViewById(R.id.edituser);
        mTextPassword = (EditText) findViewById(R.id.editpassword);
        mButtonLogin = (Button) findViewById(R.id.buttonlogin);
    }

    public void logIn(View view){
        String accountS = mTextUsername.getText().toString();
        String passworS = mTextPassword.getText().toString();
        int account = Integer.parseInt(accountS);
        int password = Integer.parseInt(passworS);
        LoginController loginController = new LoginController();
        if (loginController.login(this,account,password)){
            Intent loginIntent = new Intent(this, HomeUserActivity.class);
            loginIntent.putExtra(USER,account);
            startActivity(loginIntent);
        }

    }
}
