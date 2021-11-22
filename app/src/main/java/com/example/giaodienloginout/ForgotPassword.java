package com.example.giaodienloginout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.textclassifier.TextLinks;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ForgotPassword extends AppCompatActivity {
    EditText edtEnterEmail;
    Button btnSend;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        linkViews();
        addEvents();
    }

    private void linkViews() {
        edtEnterEmail=findViewById(R.id.edtEnterEmail);
        btnSend=findViewById(R.id.btnSend);
        DB=new DBHelper(this);

    }

    private void addEvents() {

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtEnterEmail.getText().toString();
                if(email.equals("")){
                    Toast.makeText(ForgotPassword.this, "Please enter your email", Toast.LENGTH_SHORT).show();
                }else{
                    Boolean checkemail=DB.checkEmail(email);
                    if(checkemail==true){
                        Toast.makeText(ForgotPassword.this, "Successful", Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(getApplicationContext(),ResetPassword.class);
                        intent.putExtra("email",email);
                        startActivity(intent);

                    }else {
                        Toast.makeText(ForgotPassword.this, "Email does not exists", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}