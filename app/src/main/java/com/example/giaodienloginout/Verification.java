package com.example.giaodienloginout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class Verification extends AppCompatActivity {
    Button btnVerify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);
        linkViews();
        addEvents();

    }

    private void linkViews() {
        btnVerify= findViewById(R.id.btnVerify);
    }

    private void addEvents() {
        btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(Verification.this,ResetPassword.class);
//                startActivity(intent);
            }
        });
    }
}