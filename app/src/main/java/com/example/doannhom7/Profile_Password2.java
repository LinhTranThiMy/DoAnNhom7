package com.example.doannhom7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Profile_Password2 extends AppCompatActivity {
    ImageButton btnBackPassword2;
    Button btnSavePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_password2);
        linkViews();
        addEvents();
    }

    private void linkViews() {
        btnBackPassword2= findViewById(R.id.btnBackPassword2);
        btnSavePassword=findViewById(R.id.btnSavePassword);
    }

    private void addEvents() {
        btnBackPassword2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Profile_Password2.this,Profile_Password1.class);
                startActivity(intent);
            }
        });
        btnSavePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Profile_Password2.this,Profile.class);
                startActivity(intent);
            }
        });
    }
}