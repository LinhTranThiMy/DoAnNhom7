package com.example.drawermenuex;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.adapter.BannerAdapter;
import com.example.adapter.PopularAdapter;
import com.example.adapter.ProductAdapter;
import com.example.model.AboutUs;
import com.example.model.Popular;
import com.example.model.Product;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    RecyclerView rcvPopular, rcvBanner, rcvProducts;
    PopularAdapter adapter;
    ArrayList<Product> populars;
    BannerAdapter adapter2;
    ArrayList<AboutUs> banner;
    PopularAdapter adapter1;
    ArrayList<Product> products;
    DatabaseReference Data;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        //Hiện actionBar
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();

        Data = FirebaseDatabase.getInstance().getReference();
        rcvPopular = view.findViewById(R.id.rcvPopular);
        rcvBanner = view.findViewById(R.id.rcvBanner);
        rcvProducts=view.findViewById(R.id.rcvProducts);
//
//        LinearLayoutManager linearLayoutManager =  new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false);
//        rcvPopular.setLayoutManager(linearLayoutManager);

        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false);
        rcvBanner.setLayoutManager(manager);

//        LinearLayoutManager manager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false);
//        rcvProducts.setLayoutManager(manager1);
//
//        populars = new ArrayList<Popular>();
//        populars.add(new Popular(R.drawable.case1,"CUSTOM CASE",19000));
//        populars.add(new Popular(R.drawable.case2,"CUSTOM CASE",30000));
//        populars.add(new Popular(R.drawable.case3,"CUSTOM CASE",31000));
//        populars.add(new Popular(R.drawable.case4,"CUSTOM CASE",33000));
//        populars.add(new Popular(R.drawable.case5,"CUSTOM CASE",35000));
//
//        adapter= new PopularAdapter(getContext(),populars);
//        rcvPopular.setAdapter(adapter);


        banner= new ArrayList<AboutUs>();
        banner.add(new AboutUs(R.drawable.banner1));
        banner.add(new AboutUs(R.drawable.banner2));
        adapter2 = new BannerAdapter(getContext(),banner);
        rcvBanner.setAdapter(adapter2);
        GetDataFromFirebase();

//        products = new ArrayList<Popular>();
//        products.add(new Popular(R.drawable.product1,"POPSOCKETS",19000));
//        products.add(new Popular(R.drawable.case1,"CASE",30000));
//        products.add(new Popular(R.drawable.product3,"POWERBANK",31000));
//        products.add(new Popular(R.drawable.product4,"MOUSE PAD",33000));
//
//        adapter1= new PopularAdapter(getContext(),products);
//        rcvProducts.setAdapter(adapter1);
        return view;
    }

    private void GetDataFromFirebase() {
        Data.child("BestSeller").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                populars = new ArrayList<Product>();
                LinearLayoutManager linearLayoutManager =  new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false);
                rcvPopular.setLayoutManager(linearLayoutManager);
                for (DataSnapshot snapshot : datasnapshot.getChildren()) {
                    Product product = snapshot.getValue(Product.class);
                    populars.add(product);
                }
                adapter = new PopularAdapter(getActivity(), populars);
                rcvPopular.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        Data.child("NewArrivals").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                products = new ArrayList<Product>();
                LinearLayoutManager linearLayoutManager =  new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false);
                rcvProducts.setLayoutManager(linearLayoutManager);
                for (DataSnapshot snapshot : datasnapshot.getChildren()) {
                    Product product = snapshot.getValue(Product.class);
                    products.add(product);
                }
                adapter1 = new PopularAdapter(getActivity(), products);
                rcvProducts.setAdapter(adapter1);
                adapter1.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}