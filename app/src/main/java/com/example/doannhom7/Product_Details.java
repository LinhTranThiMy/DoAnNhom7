package com.example.doannhom7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.adapter.SliderAdapter;
import com.example.model.Slider;

import java.util.ArrayList;

public class Product_Details extends AppCompatActivity {
    RecyclerView rcvSlider;
    SliderAdapter adapterSlider;
    ArrayList<Slider> sliders;

    TextView txtDescription, txtReview;
    LinearLayout layoutNoiDung;
    Button btnAddCart1,btnBuyNow1;
    ImageButton btnBackCTSP1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        linkViews();
        initData();
        configRecyclerView();
        addEvent();
    }

    private void linkViews() {

        rcvSlider= findViewById(R.id.rcvSlider);
        txtDescription= findViewById(R.id.txtDescription);
        txtReview= findViewById(R.id.txtReview);
        btnAddCart1= findViewById(R.id.btnAddCart1);
        btnBuyNow1= findViewById(R.id.btnBuyNow1);
    }

    private void addEvent() {
        txtDescription.setOnClickListener(myClick);
        txtReview.setOnClickListener(myClick);
       btnAddCart1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent= new Intent(Product_Details.this,AddCartAndBuy.class);
               startActivity(intent);
           }
       });
       btnBuyNow1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent= new Intent(Product_Details.this,AddCartAndBuy.class);
               startActivity(intent);
           }
       });
    }

    View.OnClickListener myClick= new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FragmentManager fragmentManager=getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            Fragment fragment= null;
            if(view.getId()==R.id.txtDescription){
                fragment = new Description();
            } else if (view.getId() == R.id.txtReview) {
                fragment = new Review();



            }
            if (fragment != null) {
                fragmentTransaction.replace(R.id.layoutNoiDung, fragment);
                fragmentTransaction.commit();
            }
        }
    };

    private void configRecyclerView() {
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        rcvSlider.setLayoutManager(linearLayoutManager);
    }

    private void initData() {
        sliders= new ArrayList<Slider>();
        sliders.add(new Slider(R.drawable.case1));
        sliders.add(new Slider(R.drawable.case2));
        sliders.add(new Slider(R.drawable.case3));
        sliders.add(new Slider(R.drawable.case4));
        adapterSlider= new SliderAdapter(Product_Details.this,sliders);
        rcvSlider.setAdapter(adapterSlider);
    }
}
