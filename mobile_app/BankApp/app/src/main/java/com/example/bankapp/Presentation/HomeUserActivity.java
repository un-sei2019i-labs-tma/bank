package com.example.bankapp.Presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bankapp.DataAccess.Models.Account;
import com.example.bankapp.DataAccess.Models.User;
import com.example.bankapp.DataAccess.Repository.AccountRepository;
import com.example.bankapp.DataAccess.Repository.UserRepository;
import com.example.bankapp.R;

public class HomeUserActivity extends AppCompatActivity {


    private static  final  String USER = "user";
    TextView balanceText;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_user);
        UserRepository userRepository = new UserRepository();
        int id = getIntent().getIntExtra(USER,0);
        User user = userRepository.getUserByID(this, id);
        String name = user.getName();
        AccountRepository accountRepository = new AccountRepository();
        Account account = accountRepository.getAccount(this,user.getAccount());
        balanceText= (TextView) findViewById(R.id.editbalance);
        Integer balance = account.getBalance();
        balanceText.setText("$  "+balance.toString());
    }


    public void SendMoney(View view) {
        Intent intent1 = new Intent(HomeUserActivity.this, SendUserActivity.class);
        startActivity(intent1);
    }
}
