package com.example.drawermenuex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    private EditText edtFullname, edtUsername,edtEmail,edtPassword,edtConfirmPassword,edtBirthday;
    private Button btnSignUp;
    TextView txtLogin;
    public static DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        linkViews();
        addEvent();
    }

    private void linkViews() {
        edtFullname=findViewById(R.id.edtFullname);
        edtUsername=findViewById(R.id.edtUsername);
        edtEmail=findViewById(R.id.edtEmail);
        edtBirthday=findViewById(R.id.edtBirthDay);
        edtPassword=findViewById(R.id.edtPassword);
        edtConfirmPassword=findViewById(R.id.edtConfirmPassword);
        btnSignUp=findViewById(R.id.btnSignUp);
        txtLogin=findViewById(R.id.txtLogin);
        DB= new DBHelper(this);
    }

    private void addEvent() {
        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });
    }

    private void login() {
        Intent intent= new Intent(SignUpActivity.this,LoginActivity.class);
        startActivity(intent);
    }

    private void signup() {

        String  fullname=edtFullname.getText().toString();
        String   username=edtUsername.getText().toString();
        String  email=edtEmail.getText().toString();
        String  password=edtPassword.getText().toString();
        String   confirmPassword=edtConfirmPassword.getText().toString();
        String birthday=edtBirthday.getText().toString();
        //Kiem tra nhap user,password??
        if(fullname.equals("")||username.equals("")||email.equals("")||password.equals("")||confirmPassword.equals("")||birthday.equals("")){
            Toast.makeText(this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
        }else {
            if(password.equals(confirmPassword)){
                Boolean checkprofile=DB.checkProfile( fullname,username,email,password,confirmPassword,birthday);
                if(checkprofile==false){
                    Boolean insert = DB.insertData(fullname,username,email,password,confirmPassword,birthday);
                    if(insert==true){
                        Toast.makeText(SignUpActivity.this,"Registered Successfully",Toast.LENGTH_LONG).show();
                        Intent intent= new Intent(getApplicationContext(),LoginActivity.class);
                        startActivity(intent);

                    }else {
                        Toast.makeText(SignUpActivity.this,"Registered failed",Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(SignUpActivity.this,"User already exist! Please Sign in",Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(SignUpActivity.this,"Password not matching",Toast.LENGTH_SHORT).show();
            }
        }
    }
}