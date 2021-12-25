package com.example.drawermenuex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    private EditText edtFullname, edtUsername,edtEmail,edtPassword,edtConfirmPassword,edtBirthday;
    private Button btnSignUp;
    TextView txtLogin;
    ImageView imvSigupConfirmPasswordToggle, imvSigupPasswordToggle;
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
        imvSigupConfirmPasswordToggle=findViewById(R.id.imvSigupConfirmPasswordToggle);
        imvSigupPasswordToggle=findViewById(R.id.imvSigupPasswordToggle);
        imvSigupPasswordToggle.setImageResource(R.drawable.ic_hide_pass);
        imvSigupConfirmPasswordToggle.setImageResource(R.drawable.ic_hide_pass);
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
        imvSigupPasswordToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtPassword.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())){
                    //If password is visible then Hide it
                    edtPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    //Change icon
                    imvSigupPasswordToggle.setImageResource(R.drawable.ic_hide_pass);
                }else{
                    edtPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    imvSigupPasswordToggle.setImageResource(R.drawable.ic_show_pass);
                }
            }
        });
        imvSigupConfirmPasswordToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtConfirmPassword.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())){
                    //If password is visible then Hide it
                    edtConfirmPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    //Change icon
                    imvSigupPasswordToggle.setImageResource(R.drawable.ic_hide_pass);
                }else{
                    edtConfirmPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    imvSigupPasswordToggle.setImageResource(R.drawable.ic_show_pass);
                }
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