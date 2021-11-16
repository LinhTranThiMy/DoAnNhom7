package com.example.doannhom7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Profile_MyAccount1 extends AppCompatActivity {
    ImageButton btnBackMyAccount;
    Button btnEditProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_my_account1);
        linkViews();
        addEvents();
    }

    private void linkViews() {
        btnBackMyAccount=findViewById(R.id.btnBackMyAccount);
        btnEditProfile=findViewById(R.id.btnEditProfile);
    }

    private void addEvents() {
        btnBackMyAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Profile_MyAccount1.this,Profile.class);
                startActivity(intent);
            }
        });
        btnEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Profile_MyAccount1.this,Profile_MyAccount2.class);
                startActivity(intent);
            }
        });
    }
}