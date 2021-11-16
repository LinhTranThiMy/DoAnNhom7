package com.example.doannhom7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adapter.SliderAdapter;
import com.example.model.Slider;

import java.util.ArrayList;

public class AddCartAndBuy extends AppCompatActivity {
    Spinner spSelectDevice;
    ArrayList<String> selectDevice;
    ArrayAdapter<String> adapterSelectDevice;
    RecyclerView rcvSlider;
    SliderAdapter adapterSlider;
    ArrayList<Slider> sliders;

    ImageButton btnBackCTSP2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cart_and_buy);
        linkViews();
        initData();
        addEvents();
        loadData();
        configRecyclerView();
        btnBackCTSP2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(AddCartAndBuy.this,Product_Details.class);
                startActivity(intent);
            }
        });
    }

    private void linkViews() {
        spSelectDevice= findViewById(R.id.spSelectDevice);
        btnBackCTSP2= findViewById(R.id.btnBackCTSP2);
        rcvSlider= findViewById(R.id.rcvSlider);
    }

    private void addEvents() {

    }

    private void initData() {
        selectDevice= new ArrayList<String>();
        selectDevice.add("Iphone");
        selectDevice.add("SamSung");
        selectDevice.add("Apple Watch");

        sliders= new ArrayList<Slider>();
        sliders.add(new Slider(R.drawable.case1));
        sliders.add(new Slider(R.drawable.case2));
        sliders.add(new Slider(R.drawable.case3));
        sliders.add(new Slider(R.drawable.case4));
        adapterSlider= new SliderAdapter(AddCartAndBuy.this,sliders);
        rcvSlider.setAdapter(adapterSlider);
    }

    private void configRecyclerView() {
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        rcvSlider.setLayoutManager(linearLayoutManager);
    }

    private void loadData() {
        adapterSelectDevice= new ArrayAdapter<String>(AddCartAndBuy.this, android.R.layout.simple_list_item_single_choice,selectDevice);
        spSelectDevice.setAdapter(adapterSelectDevice);
    }
}