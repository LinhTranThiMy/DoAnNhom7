package com.example.drawermenuex;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.adapter.ProductAdapter;
import com.example.model.Product;

import java.util.ArrayList;


public class AllAccesoriesFragment extends Fragment {
    GridView gvAllAccesories;
    ArrayList<Product> AllAccesories;
    ProductAdapter adapterAllAccesories;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_accesories, container, false);
        gvAllAccesories=view.findViewById(R.id.gvAllAccesories);


        AllAccesories = new ArrayList<Product>();
        AllAccesories.add(new Product(R.drawable.charger2, "CUSTOM CASE",190000, 5F,"(12)"));
        AllAccesories.add(new Product(R.drawable.cable10, "CUSTOM CASE",190000, 4F,"(12)"));
        AllAccesories.add(new Product(R.drawable.powerbank8, "CUSTOM CASE",190000,4F,"(12)"));
        AllAccesories.add(new Product(R.drawable.other1, "CUSTOM CASE",190000,4F,"(12)"));
        AllAccesories.add(new Product(R.drawable.charger4, "CUSTOM CASE",190000,4F,"(12)"));
        AllAccesories.add(new Product(R.drawable.cable5, "CUSTOM CASE",190000,4F,"(12)"));
        AllAccesories.add(new Product(R.drawable.powerbank1, "CUSTOM CASE",190000,4F,"(12)"));
        AllAccesories.add(new Product(R.drawable.other5, "CUSTOM CASE",190000,4F,"(12)"));
        AllAccesories.add(new Product(R.drawable.cable9, "CUSTOM CASE",190000,4F,"(12)"));
        AllAccesories.add(new Product(R.drawable.charger1, "CUSTOM CASE",190000,4F,"(12)"));
        AllAccesories.add(new Product(R.drawable.powerbank6, "CUSTOM CASE",190000,4F,"(12)"));
        AllAccesories.add(new Product(R.drawable.other7, "CUSTOM CASE",190000,4F,"(12)"));

        adapterAllAccesories = new ProductAdapter(getActivity(),R.layout.item_products,AllAccesories);
        gvAllAccesories.setAdapter(adapterAllAccesories);
        return view;
    }
}