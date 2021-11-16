package com.example.doannhom7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class Processing_OrderDetails extends AppCompatActivity {
    MaterialButton btnCancelOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_processing_order_details);
        linkViews();
        addEvents();
    }

    private void linkViews() {
        btnCancelOrder=findViewById(R.id.btnCancelOrder);
    }

    private void addEvents() {
        btnCancelOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Processing_OrderDetails.this,Cancelled_Reason.class);
                startActivity(intent);
            }
        });
    }
}