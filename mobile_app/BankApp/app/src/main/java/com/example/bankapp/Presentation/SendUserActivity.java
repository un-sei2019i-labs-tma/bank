package com.example.bankapp.Presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.bankapp.R;

public class SendUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_user);
    }

    public void send(View view) {
        Toast.makeText(this,"praise the sun \\[T]/",Toast.LENGTH_SHORT).show();
    }
}
