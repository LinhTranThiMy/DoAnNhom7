package com.example.drawermenuex;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.adapter.ProductAdapter;
import com.example.model.Product;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class CollectionFragment extends Fragment {
    GridView gvNewArrivals, gvPopular, gvSaleOff;
    ArrayList<Product> NewArrivals, BestSeller, SaleOfff;
    ProductAdapter adapterNewArrivals, adapterBestSeller, adapterSaleOff;
    DatabaseReference Data;
    Button btnFilter,btnCancel, btnApply;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_collection, container, false);
        //Hiện actionBar
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        gvNewArrivals=view.findViewById(R.id.gvNewArrivals);
        gvPopular=view.findViewById(R.id.gvPopular);
        gvSaleOff=view.findViewById(R.id.gvSaleOff);
        btnFilter=view.findViewById(R.id.btnFilter);
        Data = FirebaseDatabase.getInstance().getReference();
        GetDataFromFirebase();

//        NewArrivals = new ArrayList<Product>();
//        NewArrivals.add(new Product(R.drawable.case1, "CUSTOM CASE",190000,4F,"(12)"));
//        NewArrivals.add(new Product(R.drawable.case2, "CUSTOM CASE",190000,4F,"(12)"));
//        NewArrivals.add(new Product(R.drawable.case3, "CUSTOM CASE",190000,4F,"(12)"));
//        NewArrivals.add(new Product(R.drawable.case4, "CUSTOM CASE",190000,4F,"(12)"));
//        NewArrivals.add(new Product(R.drawable.case5, "CUSTOM CASE",190000,4F,"(12)"));
//        NewArrivals.add(new Product(R.drawable.case1, "CUSTOM CASE",190000,4F,"(12)"));
//
//        adapterNewArrivals = new ProductAdapter(getActivity(),R.layout.item_products,NewArrivals);
//        gvNewArrivals.setAdapter(adapterNewArrivals);
//
//        gvPopular=view.findViewById(R.id.gvPopular);
//
//
//        Popular = new ArrayList<Product>();
//        Popular.add(new Product(R.drawable.case1, "CUSTOM CASE",190000,4F,"(12)"));
//        Popular.add(new Product(R.drawable.case2, "CUSTOM CASE",190000,4F,"(12)"));
//        Popular.add(new Product(R.drawable.case3, "CUSTOM CASE",190000,4F,"(12)"));
//        Popular.add(new Product(R.drawable.case4, "CUSTOM CASE",190000,4F,"(12)"));
//        Popular.add(new Product(R.drawable.case5, "CUSTOM CASE",190000,4F,"(12)"));
//        Popular.add(new Product(R.drawable.case1, "CUSTOM CASE",190000,4F,"(12)"));
//
//        adapterPopular = new ProductAdapter(getActivity(),R.layout.item_products,Popular);
//        gvPopular.setAdapter(adapterPopular);
//
//        gvSaleOff=view.findViewById(R.id.gvSaleOff);
//
//
//        SaleOfff = new ArrayList<Product>();
//        SaleOfff.add(new Product(R.drawable.case1, "CUSTOM CASE",190000,4F,"(12)"));
//        SaleOfff.add(new Product(R.drawable.case2, "CUSTOM CASE",190000,4F,"(12)"));
//        SaleOfff.add(new Product(R.drawable.case3, "CUSTOM CASE",190000,4F,"(12)"));
//        SaleOfff.add(new Product(R.drawable.case4, "CUSTOM CASE",190000,4F,"(12)"));
//        SaleOfff.add(new Product(R.drawable.case5, "CUSTOM CASE",190000,4F,"(12)"));
//        SaleOfff.add(new Product(R.drawable.case1, "CUSTOM CASE",190000,4F,"(12)"));
//
//        adapterSaleOff = new ProductAdapter(getActivity(),R.layout.item_products,SaleOfff);
//        gvSaleOff.setAdapter(adapterSaleOff);
        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFilterDialog();
            }
        });
        return view;
    }

    private void openFilterDialog() {
        Dialog dialog=new Dialog(getActivity());
        dialog.setContentView(R.layout.fragment_filter);
        btnCancel=dialog.findViewById(R.id.btnCancel);
        btnApply=dialog.findViewById(R.id.btnApply);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        dialog.getWindow().getAttributes().windowAnimations= R.style.Animation_AppCompat_Dialog;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }

    private void GetDataFromFirebase() {
        Data.child("NewArrivals").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                NewArrivals = new ArrayList<Product>();
                for (DataSnapshot snapshot : datasnapshot.getChildren()) {
                    Product product = snapshot.getValue(Product.class);
                    NewArrivals.add(product);
                }
                adapterNewArrivals = new ProductAdapter(getActivity(), R.layout.item_products, NewArrivals);
                gvNewArrivals.setAdapter(adapterNewArrivals);
                adapterNewArrivals.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        Data.child("BestSeller").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                BestSeller = new ArrayList<Product>();
                for (DataSnapshot snapshot : datasnapshot.getChildren()) {
                    Product product = snapshot.getValue(Product.class);
                    BestSeller.add(product);
                }
                adapterBestSeller = new ProductAdapter(getActivity(), R.layout.item_products, BestSeller);
                gvPopular.setAdapter(adapterBestSeller);
                adapterBestSeller.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        Data.child("SaleOff").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                SaleOfff = new ArrayList<Product>();
                for (DataSnapshot snapshot : datasnapshot.getChildren()) {
                    Product product = snapshot.getValue(Product.class);
                    SaleOfff.add(product);
                }
                adapterSaleOff = new ProductAdapter(getActivity(), R.layout.item_products, SaleOfff);
                gvSaleOff.setAdapter(adapterSaleOff);
                adapterSaleOff.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}