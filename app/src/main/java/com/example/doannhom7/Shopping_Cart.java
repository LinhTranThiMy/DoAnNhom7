package com.example.doannhom7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Shopping_Cart extends AppCompatActivity {
    ImageButton btnBackCart;
    Button btnCheckOut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        linkViews();
        addEvents();
    }


    private void linkViews() {
        btnBackCart= findViewById(R.id.btnBackCart);
        btnCheckOut=findViewById(R.id.btnCheckOut);

    }

    private void addEvents() {
        btnBackCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Shopping_Cart.this,HomePage.class);
                startActivity(intent);
            }
        });
        btnCheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Shopping_Cart.this,Checkout.class);
                startActivity(intent);
            }
        });

    }
}