package com.example.drawermenuex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class ProfileMyAccount2 extends AppCompatActivity {
    Button btnSaveProfile;
    ImageButton btnBackMyAccount2;
    EditText edtFullName,edtUserName,edtEmail,edtBirthDay;
    public static DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_my_account2);
        linkViews();
        addEvent();
    }

    private void linkViews() {
        btnSaveProfile=findViewById(R.id.btnSaveProfile);
        btnBackMyAccount2=findViewById(R.id.btnBackMyAccount2);
        edtFullName=findViewById(R.id.edtFullName);
        edtUserName=findViewById(R.id.edtUsername);
        edtEmail=findViewById(R.id.edtEmail);
        edtBirthDay=findViewById(R.id.edtBirthDay);
    }

    private void addEvent() {
        btnBackMyAccount2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ProfileMyAccount2.this,ProfileMyAccount1.class);
                startActivity(intent);
            }
        });
        btnSaveProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
//                Intent intent= new Intent(ProfileMyAccount2.this,ProfileFragment.class);
//                startActivity(intent);
            }
        });
    }
}