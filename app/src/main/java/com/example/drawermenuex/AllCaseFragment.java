package com.example.drawermenuex;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.adapter.ProductAdapter;
import com.example.model.Product;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class AllCaseFragment extends Fragment {
    GridView gvAllCases;
    ArrayList<Product> AllCases;
    ProductAdapter adapterAllCase;
    DatabaseReference Data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_case, container, false);
        gvAllCases=view.findViewById(R.id.gvAllCase);
        Data = FirebaseDatabase.getInstance().getReference();
        GetDataFromFirebase();
        return view;
    }

    private void GetDataFromFirebase() {
        Data.child("AllCase").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                AllCases = new ArrayList<Product>();
                for (DataSnapshot snapshot : datasnapshot.getChildren()) {
                    Product product = snapshot.getValue(Product.class);
                    AllCases.add(product);
                }
                adapterAllCase = new ProductAdapter(getActivity(), R.layout.item_products, AllCases);
                gvAllCases.setAdapter(adapterAllCase);
                adapterAllCase.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}