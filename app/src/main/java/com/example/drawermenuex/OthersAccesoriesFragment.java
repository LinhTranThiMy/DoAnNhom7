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


public class OthersAccesoriesFragment extends Fragment {

    GridView gvOthersAccesories;
    ArrayList<Product> OthersAccesories;
    ProductAdapter adapterOthersAccesories;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_others_accesories, container, false);
        gvOthersAccesories=view.findViewById(R.id.gvOthersAccesories);


        OthersAccesories = new ArrayList<Product>();
        OthersAccesories.add(new Product(R.drawable.other1, "CUSTOM CASE",190000, 5F,"(12)"));
        OthersAccesories.add(new Product(R.drawable.other2, "CUSTOM CASE",190000, 4F,"(12)"));
        OthersAccesories.add(new Product(R.drawable.other3, "CUSTOM CASE",190000,4F,"(12)"));
        OthersAccesories.add(new Product(R.drawable.other4, "CUSTOM CASE",190000,4F,"(12)"));
        OthersAccesories.add(new Product(R.drawable.other5, "CUSTOM CASE",190000,4F,"(12)"));
        OthersAccesories.add(new Product(R.drawable.other6, "CUSTOM CASE",190000,4F,"(12)"));
        OthersAccesories.add(new Product(R.drawable.other7, "CUSTOM CASE",190000,4F,"(12)"));
        OthersAccesories.add(new Product(R.drawable.other8, "CUSTOM CASE",190000,4F,"(12)"));
        OthersAccesories.add(new Product(R.drawable.other9, "CUSTOM CASE",190000,4F,"(12)"));
        OthersAccesories.add(new Product(R.drawable.other10, "CUSTOM CASE",190000,4F,"(12)"));
        OthersAccesories.add(new Product(R.drawable.other11, "CUSTOM CASE",190000,4F,"(12)"));
        OthersAccesories.add(new Product(R.drawable.other5, "CUSTOM CASE",190000,4F,"(12)"));

        adapterOthersAccesories = new ProductAdapter(getActivity(),R.layout.item_products,OthersAccesories);
        gvOthersAccesories.setAdapter(adapterOthersAccesories);
        return view;
    }
}