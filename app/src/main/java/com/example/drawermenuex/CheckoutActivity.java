package com.example.drawermenuex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class CheckoutActivity extends AppCompatActivity {
    ImageButton btnCloseCheckOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        btnCloseCheckOut=findViewById(R.id.btnCloseCheckOut);
        btnCloseCheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(CheckoutActivity.this,ShoppingCartFragment.class);
                startActivity(intent);
            }
        });
        getSupportFragmentManager().beginTransaction().add(R.id.layout_Checkout,new Checkout1Fragment()).commit();
    }
}