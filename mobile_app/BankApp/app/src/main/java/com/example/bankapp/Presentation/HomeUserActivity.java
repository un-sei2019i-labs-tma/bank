package com.example.bankapp.Presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.bankapp.R;

public class HomeUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_user);
    }


    public void SendMoney(View view) {
        Intent intent1 = new Intent(HomeUserActivity.this, SendUserActivity.class);
        startActivity(intent1);
    }
}
