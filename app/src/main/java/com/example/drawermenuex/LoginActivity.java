package com.example.drawermenuex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText edtUsername,edtPassword;
    Button btnLogin;
    TextView txtForgot,txtSignUp;
    private DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        linkViews();
        addEvent();
    }

    private void linkViews() {
        edtUsername=findViewById(R.id.edtUsername);
        edtPassword=findViewById(R.id.edtPassword);
        btnLogin=findViewById(R.id.btnLogin);
        txtForgot=findViewById(R.id.txtForgot);
        txtSignUp=findViewById(R.id.txtSignUp);
        DB= new DBHelper(this);
    }

    private void addEvent() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        txtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });
        txtForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(LoginActivity.this,ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });
    }

    private void signup() {
        Intent intent= new Intent(LoginActivity.this, com.example.drawermenuex.SignUpActivity.class);
        startActivity(intent);
    }

    private void login() {
        String username,password;
        username=edtUsername.getText().toString();
        password=edtPassword.getText().toString();
        //Kiem tra nhap user,password??
        if(username.equals("")||password.equals("")){
            Toast.makeText(LoginActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
        }
        else{
            Boolean checkaccount=DB.checkAccount(username,password);
            if (checkaccount==true){
                Toast.makeText(LoginActivity.this, "Sign in successful", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }else {
                Toast.makeText(LoginActivity.this, "Invalid credential", Toast.LENGTH_SHORT).show();
            }
        }
    }
}