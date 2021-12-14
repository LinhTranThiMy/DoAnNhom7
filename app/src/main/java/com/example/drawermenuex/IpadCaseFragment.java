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


public class IpadCaseFragment extends Fragment {
    GridView gvIpadCases;
    ArrayList<Product> IpadCases;
    ProductAdapter adapterIpadCase;
    DatabaseReference Data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ipad_case, container, false);
        gvIpadCases=view.findViewById(R.id.gvIpadCases);


        Data = FirebaseDatabase.getInstance().getReference();
        GetDataFromFirebase();
        return view;
    }

    private void GetDataFromFirebase() {
        Data.child("IpadCase").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                IpadCases = new ArrayList<Product>();
                for (DataSnapshot snapshot : datasnapshot.getChildren()) {
                    Product product = snapshot.getValue(Product.class);
                    IpadCases.add(product);
                }
                adapterIpadCase = new ProductAdapter(getActivity(), R.layout.item_products, IpadCases);
                gvIpadCases.setAdapter(adapterIpadCase);
                adapterIpadCase.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}