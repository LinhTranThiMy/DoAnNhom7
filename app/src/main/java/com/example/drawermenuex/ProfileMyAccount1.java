package com.example.drawermenuex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class ProfileMyAccount1 extends AppCompatActivity {
    Button btnEditProfile;
    ImageButton btnBackMyAccount1;
    TextView txtFullName,txtUserName,txtEmail,txtBirthDay;
    public static DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_my_account1);
        linkViews();
        addEvents();
    }

    private void linkViews() {
        btnEditProfile=findViewById(R.id.btnEditProfile);
        btnBackMyAccount1=findViewById(R.id.btnBackMyAccount1);
        txtFullName=findViewById(R.id.txtFullName);
        txtUserName=findViewById(R.id.txtUserName);
        txtEmail=findViewById(R.id.txtEmail);
        txtBirthDay=findViewById(R.id.txtBirthDay);
    }

    private void addEvents() {
        btnEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileMyAccount1.this, ProfileMyAccount2.class);

                startActivity(intent);
            }
        });
    }
}