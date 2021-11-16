package com.example.doannhom7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ResetPassword extends AppCompatActivity {
    ImageView imvBackReset;
    Button btnResetPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        linkViews();
        addEvents();
    }

    private void linkViews() {
        imvBackReset=findViewById(R.id.imvBackReset);
        btnResetPassword=findViewById(R.id.btnResetPassword);

    }

    private void addEvents() {
        imvBackReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ResetPassword.this,Verification.class);
                startActivity(intent);
            }
        });
       btnResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ResetPassword.this,Login.class);
                startActivity(intent);
            }
        });
    }
}