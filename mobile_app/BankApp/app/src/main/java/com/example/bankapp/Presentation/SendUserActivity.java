package com.example.bankapp.Presentation;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bankapp.BusinessLogic.SendMoneyController;
import com.example.bankapp.DataAccess.DataBase.DataBase;
import com.example.bankapp.DataAccess.Models.Account;
import com.example.bankapp.DataAccess.Models.User;
import com.example.bankapp.DataAccess.Repository.AccountRepository;
import com.example.bankapp.DataAccess.Repository.UserRepository;
import com.example.bankapp.R;

public class SendUserActivity extends AppCompatActivity {

    EditText mTextUserAccountEnd;
    EditText mTextAmount;
    Button mButtonSend;
    private static final String USER = "user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_user);

        mTextUserAccountEnd = (EditText) findViewById(R.id.editusers);
        mTextAmount = (EditText) findViewById(R.id.editsendmoney);
        mButtonSend = (Button) findViewById(R.id.buttonsend);
    }

    public void send(View view) {


        String userAccountEnd = mTextUserAccountEnd.getText().toString();
        int endUserAccountID = Integer.parseInt(userAccountEnd);
        String amountS = mTextAmount.getText().toString();
        double amount = Double.parseDouble(amountS);
        int originUser = getIntent().getIntExtra(USER,0);
        UserRepository userRepository = new UserRepository();
        User userOrigin = userRepository.getUserByID(this,originUser);
        AccountRepository accountRepository = new AccountRepository();
        Account accountOrigin = accountRepository.getAccount(this,userOrigin.getAccount());

        SendMoneyController sendMoneyController = new SendMoneyController();
        int message = sendMoneyController.send(this,accountOrigin.getIdAccount(),endUserAccountID,amount);

        switch(message) {
            case 0:
                Toast.makeText(this,"SUCCESFUL TRANSACTION -- praise the sun \\[T]/",Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(this," INSUFFICIENT BALANCE ",Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this,"INVALID ACCOUNT ",Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this,"FAILED TRANSACTION ",Toast.LENGTH_SHORT).show();
        }

        Intent ToHomeUser = new Intent(this,HomeUserActivity.class);
        ToHomeUser.putExtra(USER,userOrigin.getIdUser());
        startActivity(ToHomeUser);

    }


}
