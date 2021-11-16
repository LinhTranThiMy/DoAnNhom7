package com.example.doannhom7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class Cancelled_Reason extends AppCompatActivity {
    Button btnSubmit;
    Spinner spCancelRequest;
    ArrayList<String> reasons;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancelled_reason);
        linkViews();
        initData();
        loadData();
        addEvents();
    }

    private void linkViews() {
        spCancelRequest = findViewById(R.id.spCancelRequest);
        btnSubmit=findViewById(R.id.btnSubmit);
    }

    private void addEvents() {
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Cancelled_Reason.this,MyOrders.class);
                startActivity(intent);
            }
        });
    }

    private void initData() {
        reasons = new ArrayList<String>();
        reasons.add("Select reason");
        reasons.add("I have changed my mind");
        reasons.add("I bought the wrong item(s)");
        reasons.add("I placed a duplicate order");
        reasons.add("I received negative feedback about the item after purchase");
        reasons.add("Delivery takes too long");
        reasons.add("I want to change payment method");
        reasons.add("Other");
    }

    private void loadData() {
        adapter = new ArrayAdapter<String>(Cancelled_Reason.this,
                android.R.layout.simple_spinner_dropdown_item, reasons);
        spCancelRequest.setAdapter(adapter);
    }
}