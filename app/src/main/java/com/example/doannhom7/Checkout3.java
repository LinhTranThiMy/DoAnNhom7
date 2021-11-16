package com.example.doannhom7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.button.MaterialButton;

public class Checkout3 extends AppCompatActivity {
    MaterialButton btnBackCheckOut3;
    Button btnConfirmCheckOut3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout3);
        linkViews();
        addEvents();
    }

    private void linkViews() {
        btnBackCheckOut3=findViewById(R.id.btnBackCheckOut3);
        btnConfirmCheckOut3=findViewById(R.id.btnConfirmCheckOut3);
    }

    private void addEvents() {
        btnBackCheckOut3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Checkout3.this,Checkout2.class);
                startActivity(intent);
            }
        });
        btnConfirmCheckOut3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Checkout3.this,Confirmation.class);
                startActivity(intent);
            }
        });
    }
}