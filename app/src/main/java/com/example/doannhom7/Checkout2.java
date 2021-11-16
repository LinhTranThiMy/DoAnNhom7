package com.example.doannhom7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.button.MaterialButton;

public class Checkout2 extends AppCompatActivity {
    MaterialButton  btnBackCheckOut2;
    Button btnContinueCheckOut2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout2);
        linkViews();
        addEvents();
    }

    private void linkViews() {
        btnBackCheckOut2=findViewById(R.id.btnBackCheckOut2);
        btnContinueCheckOut2=findViewById(R.id.btnContinueCheckOut2);
    }

    private void addEvents() {
        btnBackCheckOut2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Checkout2.this,Checkout.class);
                startActivity(intent);
            }
        });
        btnContinueCheckOut2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Checkout2.this,Checkout3.class);
                startActivity(intent);
            }
        });
    }
}