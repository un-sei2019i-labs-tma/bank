package com.example.bankapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLData;

public class MainActivity extends AppCompatActivity {

    EditText mTextUsername;
    EditText mTextPassword;
    Button mButtonLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataAccess admin = new DataAccess(this,"DataBase",null,1);

        // create test user
        SQLiteDatabase DB = admin.getWritableDatabase();
        ContentValues register = new ContentValues();
        register.put("id",1);
        register.put("name","7");
        register.put("password",123456);

        DB.insert("user",null,register);
        DB.close();


        mTextUsername = (EditText) findViewById(R.id.edituser);
        mTextPassword = (EditText) findViewById(R.id.editpassword);
        mButtonLogin = (Button) findViewById(R.id.buttonlogin);
    }

    public void logIn(View view){
        DataAccess admin = new DataAccess(this,"DataBase",null,1);
        SQLiteDatabase DB = admin.getWritableDatabase();
        String user = mTextUsername.getText().toString();
        String password = mTextPassword.getText().toString();
        if (!user.isEmpty() && !password.isEmpty()){
            Cursor row = DB.rawQuery("SELECT name, password FROM user WHERE name ="+user.trim(),null);

            if (row.moveToFirst()){

                if (row.getString(1).equals(password)){
                    Toast.makeText(this,"Todo correcto :D",Toast.LENGTH_SHORT).show();
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
