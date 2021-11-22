package com.example.giaodienloginout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
    private EditText edtUsername,edtEmail,edtPassword,edtConfirmPassword;
    private Button btnSignUp;
    TextView txtLogin;

    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
       // mAuth=FirebaseAuth.getInstance();
        linkViews();
        addEvent();

    }

    private void linkViews() {
        edtUsername=findViewById(R.id.edtUsername);
        edtEmail=findViewById(R.id.edtEmail);
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
        Intent intent= new Intent(SignUp.this,LoginActivity.class);
        startActivity(intent);
    }

    private void signup() {
        String username,email,password,confirmPassword;
        username=edtUsername.getText().toString();
        email=edtEmail.getText().toString();
        password=edtPassword.getText().toString();
        confirmPassword=edtConfirmPassword.getText().toString();
        //Kiem tra nhap user,password??
        if(username.equals("")||email.equals("")||password.equals("")||confirmPassword.equals("")){
            Toast.makeText(this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
        }else {
            if(password.equals(confirmPassword)){
                Boolean checkuser=DB.checkUsername(username);
                if(checkuser==false){
                    Boolean insert = DB.insertData(username,email,password,confirmPassword);
                    if(insert==true){
                        Toast.makeText(SignUp.this,"Registered Successfully",Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(getApplicationContext(),HomePage.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(SignUp.this,"Registered failed",Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(SignUp.this,"User already exist! Please Sign in",Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(SignUp.this,"Password not matching",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
