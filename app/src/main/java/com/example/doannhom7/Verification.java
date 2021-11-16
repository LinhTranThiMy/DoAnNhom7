package com.example.doannhom7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Verification extends AppCompatActivity {
    ImageView imvClose;
    Button btnVerify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);
        linkViews();
        addEvents();
    }

    private void linkViews() {
        imvClose=findViewById(R.id.imvClose);
        btnVerify=findViewById(R.id.btnVerify);
    }

    private void addEvents() {
        imvClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Verification.this, ForgotPassword.class);
                startActivity(intent);
            }
        });
        btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Verification.this, ResetPassword.class);
                startActivity(intent);
            }
        });
    }
}