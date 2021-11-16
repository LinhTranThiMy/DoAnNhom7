package com.example.doannhom7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Profile_Password1 extends AppCompatActivity {
    ImageButton btnBackPassword1;
    Button btnChangePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_password1);
        linkViews();
        addEvents();
    }

    private void linkViews() {
        btnBackPassword1= findViewById(R.id.btnBackPassword1);
        btnChangePassword=findViewById(R.id.btnChangePassword);
    }

    private void addEvents() {
        btnBackPassword1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        Intent intent= new Intent(Profile_Password1.this,Profile.class);
        startActivity(intent);
            }
        });
        btnChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Profile_Password1.this,Profile_Password2.class);
                startActivity(intent);
            }
        });
    }
}