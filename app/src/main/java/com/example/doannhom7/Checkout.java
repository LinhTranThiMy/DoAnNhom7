package com.example.doannhom7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import java.util.ArrayList;

public class Checkout extends AppCompatActivity {
    ImageButton btnBackChekOut;
    Button btnContinueCheckOut1;
    Spinner spProvince, spDistrict, spWard;
    ArrayList<String> provinces,districts, wards;
    ArrayAdapter<String> adapterprovince, adapterdistrict, adapterward;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        linkViews();
        initData();
        loadData();
        addEvents();

    }


    private void linkViews() {
        spProvince= findViewById(R.id.spProvince);
        spDistrict=findViewById(R.id.spDistrict);
        spWard= findViewById(R.id.spWard);
        btnContinueCheckOut1=findViewById(R.id.btnContinueCheckOut1);
        btnBackChekOut=findViewById(R.id.btnBackCheckOut);
    }

    private void addEvents() {
        btnBackChekOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Checkout.this,Shopping_Cart.class);
                startActivity(intent);
            }
        });
        btnContinueCheckOut1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Checkout.this,Checkout2.class);
                startActivity(intent);
            }
        });

    }

    private void initData() {
        provinces= new ArrayList<String>();
        provinces.add("Hà Nội");
        provinces.add("Lào Cai");
        provinces.add("Cao Bằng");
        provinces.add("Lạng Sơn");
        provinces.add("Hà Tĩnh");
        provinces.add("Thừa Thiên Huế");
        provinces.add("Nghệ An");
        provinces.add("Quảng Nam");
        provinces.add("Quảng Ngãi");
        provinces.add("Đà Nẵng");
        provinces.add("TP HCM");
        provinces.add("Đắk Lắk");
        provinces.add("Lâm Đồng");
        provinces.add("Bình Phước");
        provinces.add("Tây Ninh");
        provinces.add("Cà Mau");
        provinces.add("Kiên Giang");
        provinces.add("Vĩnh Long");

        districts= new ArrayList<String>();
        districts.add("Đồng Xoài");
        districts.add("Phước Long");
        districts.add("Bình Long");
        districts.add("Chơn Thành");
        districts.add("Đồng Phú");
        districts.add("Bù Đăng");
        districts.add("Bù Đốp");
        districts.add("Bù Gia Mập");
        districts.add("Lộc Ninh");
        districts.add(" Hớn Quản");
        districts.add("Phú Riềng");
        districts.add("Quận 1");
        districts.add("Quận 2");
        districts.add("Quận 3");
        districts.add("Quận 4");
        districts.add("Quận 5");
        districts.add("Quận 5");
        districts.add("Quận 5");
        districts.add("Quận 6");
        districts.add("Quận 7");
        districts.add("Quận 8");
        districts.add("Quận 9");
        districts.add("Quận 10");
        districts.add("Quận 11");
        districts.add("Quận 12");
        districts.add("Quận Tân Bình");
        districts.add("Quận Bình Thạnh");
        districts.add("Thủ Đức");


        wards= new ArrayList<String>();
        wards.add("Thác Mơ");
        wards.add(" Long Thuỷ");
        wards.add(" Phước Bình");
        wards.add(" Long Phước");
        wards.add("Sơn Giang");
        wards.add("Long Giang");
        wards.add("Phước Tín");
        wards.add("Tân Phú");
        wards.add("Tân Đồng");
        wards.add("Tân Bình");
        wards.add("Tân Xuân");
        wards.add("Tân Thiện");
        wards.add("Tân Thành");
        wards.add("Bù Gia Mập");
        wards.add("Đak Ơ");
        wards.add("Đức Hạn");
        wards.add("Phú Văn");
        wards.add("Đa Kia");
        wards.add("Phước Minh");
        wards.add("Bình Thắng");
        wards.add("Phú Nghĩa");
        wards.add("Lộc Ninh");
        wards.add("Lộc Hoà");
    }

    private void loadData() {
        adapterprovince= new ArrayAdapter<String>(Checkout.this, android.R.layout.simple_spinner_item, provinces);
        spProvince.setAdapter(adapterprovince);
        adapterdistrict= new ArrayAdapter<String>(Checkout.this, android.R.layout.simple_spinner_item, districts);
        spDistrict.setAdapter(adapterdistrict);
        adapterward= new ArrayAdapter<String>(Checkout.this, android.R.layout.simple_spinner_item, wards);
        spWard.setAdapter(adapterdistrict);
    }
}