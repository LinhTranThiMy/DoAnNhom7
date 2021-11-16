package com.example.doannhom7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    Button btnSignUp;
    TextView txtLogin;
    EditText edtUserName, edtPassword, edtConfirmPass, edtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        linkViews();
        addEvents();
    }

    private void linkViews() {
        btnSignUp=findViewById(R.id.btnSignUp);
        txtLogin=findViewById(R.id.txtLogin);
        edtUserName=findViewById(R.id.edtUsername);
        edtPassword=findViewById(R.id.edtPassword);
        edtConfirmPass=findViewById(R.id.edtConfirmPassword);
        edtEmail=findViewById(R.id.edtEmail);
    }

    private void addEvents() {
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (edtUserName == null || edtPassword == null || edtConfirmPass == null || edtEmail == null){
                    Toast.makeText(SignUp.this, "Please enter information", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(SignUp.this, "Sign Up Success", Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(SignUp.this,Login.class);
                    startActivity(intent);
                }


            }
        });
        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SignUp.this,Login.class);
                startActivity(intent);
            }
        });
    }
}