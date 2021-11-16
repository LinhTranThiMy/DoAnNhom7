package com.example.doannhom7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Profile_MyAccount2 extends AppCompatActivity {
    ImageButton btnBackMyAccount2;
    Button  btnSaveProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_my_account2);
        linkViews();
        addEvents();
    }
    private void linkViews() {
        btnBackMyAccount2=findViewById(R.id.btnBackMyAccount2);
        btnSaveProfile=findViewById(R.id.btnSaveProfile);
    }

    private void addEvents() {
        btnBackMyAccount2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Profile_MyAccount2.this,Profile_MyAccount1.class);
                startActivity(intent);
            }
        });
        btnSaveProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Profile_MyAccount2.this,Profile.class);
                startActivity(intent);
            }
        });
    }
}