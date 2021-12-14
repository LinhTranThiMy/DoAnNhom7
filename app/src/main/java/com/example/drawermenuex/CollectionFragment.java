package com.example.drawermenuex;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    ArrayList<Product> NewArrivals, Popular, SaleOfff;
    ProductAdapter adapterNewArrivals, adapterPopular, adapterSaleOff;
    DatabaseReference Data;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_collection, container, false);
        //Hiện actionBar
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        gvNewArrivals=view.findViewById(R.id.gvNewArrivals);

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
        return view;
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
    }
}