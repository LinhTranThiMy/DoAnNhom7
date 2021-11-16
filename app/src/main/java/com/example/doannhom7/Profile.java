package com.example.doannhom7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Profile extends AppCompatActivity {
    ImageButton btnBackProfile;
    Button btnMyAccount,btnPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        linkViews();
        addEvents();
    }

    private void linkViews() {
        btnBackProfile=findViewById(R.id.btnBackProfile);
        btnMyAccount=findViewById(R.id.btnMyAccount);
        btnPassword=findViewById(R.id.btnPassword);
    }

    private void addEvents() {
        btnBackProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Profile.this,Account.class);
                startActivity(intent);
            }
        });
        btnMyAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Profile.this,Profile_MyAccount1.class);
                startActivity(intent);
            }
        });
        btnPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Profile.this,Profile_Password1.class);
                startActivity(intent);
            }
        });
    }
}