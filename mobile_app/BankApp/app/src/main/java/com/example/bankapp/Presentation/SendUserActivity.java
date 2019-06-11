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
import com.example.bankapp.DataAccess.Repository.AccountRepository;
import com.example.bankapp.R;

public class SendUserActivity extends AppCompatActivity {

    EditText mTextUserEnd;
    EditText mTextAmount;
    Button mButtonSend;
    private static final String USER_ACCOUNT = "user_account";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_user);

        mTextUserEnd = (EditText) findViewById(R.id.editusers);
        mTextAmount = (EditText) findViewById(R.id.editsendmoney);
        mButtonSend = (Button) findViewById(R.id.buttonsend);
    }

    public void send(View view) {


        String userEnd = mTextUserEnd.getText().toString();
        int uEnd = Integer.parseInt(userEnd);
        String amount = mTextAmount.getText().toString();
        int amoun = Integer.parseInt(amount);
        int oUser = Integer.parseInt(USER_ACCOUNT);

        SendMoneyController sendMoneyController = new SendMoneyController();
        int message = sendMoneyController.send(this,oUser,uEnd,amoun);

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
        startActivity(ToHomeUser);

    }


}
