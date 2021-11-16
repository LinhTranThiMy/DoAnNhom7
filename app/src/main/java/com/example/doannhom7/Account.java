package com.example.doannhom7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Account extends AppCompatActivity {
    Button btnProfile,btnPoints,btnMyOrder,btnLogOut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        linkViews();
        addEvents();
    }

    private void linkViews() {
        btnProfile=findViewById(R.id.btnProfile);
        btnPoints=findViewById(R.id.btnPoints);
        btnMyOrder=findViewById(R.id.btnMyOrder);
        btnLogOut=findViewById(R.id.btnLogOut);


    }

    private void addEvents() {
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Account.this,Profile.class);
                startActivity(intent);
            }
        });
        btnPoints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Account.this,Point.class);
                startActivity(intent);
            }
        });
        btnMyOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Account.this,MyOrders.class);
                startActivity(intent);
            }
        });
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Account.this,Login.class);
                startActivity(intent);
            }
        });

    }
}