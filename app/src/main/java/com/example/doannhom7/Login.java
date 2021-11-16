package com.example.doannhom7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;

public class Login extends AppCompatActivity {
    Button btnLogin;
    TextView txtForgot,txtSignUp;
    EditText edtUsername, edtPassword;
    String USERNAME = "user1", PASSWORD = "123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        linkViews();
        addEvents();
    }

    private void linkViews() {
        btnLogin= findViewById(R.id.btnLogin);
        txtForgot=findViewById(R.id.txtForgot);
        txtSignUp=findViewById(R.id.txtSignUp);
        edtUsername=findViewById(R.id.edtUsername);
        edtPassword=findViewById(R.id.edtPassword);
    }

    private void addEvents() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (edtUsername == null || edtPassword == null){
                    Toast.makeText(Login.this, "Enter your username, password", Toast.LENGTH_SHORT).show();
                }

                else {
                    if (edtUsername.getText().equals(USERNAME) && edtUsername.getText().equals(PASSWORD)){
                        Intent intent=new Intent(Login.this,HomePage.class);
                        startActivity(intent);
                    }
                    else Toast.makeText(Login.this, "Username or Password is not wrong", Toast.LENGTH_SHORT).show();
                }

            }
        });
        txtForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this,ForgotPassword.class);
                startActivity(intent);
            }
        });
        txtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this,SignUp.class);
                startActivity(intent);
            }
        });
    }
}