package com.example.doannhom7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.adapter.BannerAdapter;
import com.example.adapter.PopularAdapter;
import com.example.model.AboutUs;
import com.example.model.Popular;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {
    RecyclerView rcvPopular, rcvBanner, rcvProducts;
    PopularAdapter adapter;
    ArrayList<Popular> populars;
    BannerAdapter adapter2;
    ArrayList<AboutUs> banner;
    PopularAdapter adapter1;
    ArrayList<Popular> products;
    androidx.appcompat.widget.Toolbar toolbar;
    DrawerLayout drawerLayoutmain;
    BottomNavigationView bottom_navigation_view_main;
    NavigationView navigationbarmain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        linkViews();
        addEvents();
        actionBar();
        configRecyclerView();
        initData();
    }

    private void linkViews() {
        toolbar=findViewById(R.id.toolbarmain);
        drawerLayoutmain=findViewById(R.id.drawerlayouthomepage);
        rcvPopular = findViewById(R.id.rcvPopular);
        rcvBanner = findViewById(R.id.rcvBanner);
        rcvProducts=findViewById(R.id.rcvProducts);
        navigationbarmain = findViewById(R.id.navigationbarmain);
        bottom_navigation_view_main = findViewById(R.id.bottom_navigation_bar);
    }

    private void addEvents() {
        bottom_navigation_view_main.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId())
                {
                    case R.id.search:
                        Intent intent= new Intent(HomePage.this,Search.class);
                        startActivity(intent);
                        break;
                    case R.id.profile:
                        Intent intent1 = new Intent(HomePage.this,Account.class);
                        startActivity(intent1);
                        break;
                    case R.id.menucart:
                        Intent intent2 = new Intent(HomePage.this,Shopping_Cart.class);
                        startActivity(intent2);
                        break;
                }
                return false;
            }
        });

    }

    private void actionBar() {
        setSupportActionBar(toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayoutmain.openDrawer(GravityCompat.START);
            }
        });
    }

    private void configRecyclerView() {
        LinearLayoutManager linearLayoutManager =  new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        rcvPopular.setLayoutManager(linearLayoutManager);

        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        rcvBanner.setLayoutManager(manager);

        LinearLayoutManager manager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        rcvProducts.setLayoutManager(manager1);
    }

    private void initData() {
        populars = new ArrayList<Popular>();
        populars.add(new Popular(R.drawable.case1,"CUSTOM CASE",19000));
        populars.add(new Popular(R.drawable.case2,"CUSTOM CASE",30000));
        populars.add(new Popular(R.drawable.case3,"CUSTOM CASE",31000));
        populars.add(new Popular(R.drawable.case4,"CUSTOM CASE",33000));
        populars.add(new Popular(R.drawable.case5,"CUSTOM CASE",35000));

        adapter= new PopularAdapter(HomePage.this,populars);
        rcvPopular.setAdapter(adapter);


        banner= new ArrayList<AboutUs>();
        banner.add(new AboutUs(R.drawable.banner1));
        banner.add(new AboutUs(R.drawable.banner2));
        adapter2 = new BannerAdapter(HomePage.this,banner);
        rcvBanner.setAdapter(adapter2);

        products = new ArrayList<Popular>();
        products.add(new Popular(R.drawable.product1,"POPSOCKETS",19000));
        products.add(new Popular(R.drawable.case1,"CASE",30000));
        products.add(new Popular(R.drawable.product3,"POWERBANK",31000));
        products.add(new Popular(R.drawable.product4,"MOUSE PAD",33000));

        adapter1= new PopularAdapter(HomePage.this,products);
        rcvProducts.setAdapter(adapter1);
    }
}