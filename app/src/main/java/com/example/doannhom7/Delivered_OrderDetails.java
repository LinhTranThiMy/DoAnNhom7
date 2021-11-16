package com.example.doannhom7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Delivered_OrderDetails extends AppCompatActivity {
    Button btnRateUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivered_order_details);
        linkViews();
        addEvents();
    }

    private void linkViews() {
        btnRateUs=findViewById(R.id.btnRateUs);
    }

    private void addEvents() {
        btnRateUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Delivered_OrderDetails.this,RateUs.class);
                startActivity(intent);
            }
        });
    }
}