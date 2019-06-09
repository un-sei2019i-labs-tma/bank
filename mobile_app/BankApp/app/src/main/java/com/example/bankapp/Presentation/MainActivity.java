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

import com.example.bankapp.DataAccess.DataBase.DataBase;
import com.example.bankapp.DataAccess.Models.User;
import com.example.bankapp.DataAccess.Repository.UserRepository;
import com.example.bankapp.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText mTextUsername;
    EditText mTextPassword;
    Button mButtonLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        // create test use
        //SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        User user = new User(1,"pepito","perez",654321,123456789,"test@test.com",000000,date );
        UserRepository repo= new UserRepository();
        repo.createUser(this,user);
        mTextUsername = (EditText) findViewById(R.id.edituser);
        mTextPassword = (EditText) findViewById(R.id.editpassword);
        mButtonLogin = (Button) findViewById(R.id.buttonlogin);
    }

    public void logIn(View view){
        DataBase admin = new DataBase(this,"DataBase",null,1);
        SQLiteDatabase DB = admin.getWritableDatabase();
        String user = mTextUsername.getText().toString();
        String password = mTextPassword.getText().toString();
        if (!user.isEmpty() && !password.isEmpty()){
            Cursor row = DB.rawQuery("SELECT idUser, password FROM user WHERE idUser ="+user.trim(),null);

            if (row.moveToFirst()){

                if (row.getString(1).equals(password)){
                    Intent intent1 = new Intent(MainActivity.this, HomeUserActivity.class);
                    startActivity(intent1);
                }else {
                    Toast.makeText(this,"Password incorecto",Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(this,"El nombre de usuario es incorrecto",Toast.LENGTH_SHORT).show();
            }
            DB.close();
        }else{
            Toast.makeText(this,"Por favor llenar todos los campos ",Toast.LENGTH_SHORT).show();


        }


    }
}
