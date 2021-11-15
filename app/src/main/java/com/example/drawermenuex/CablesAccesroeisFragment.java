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


public class CablesAccesroeisFragment extends Fragment {
    GridView gvCablesAccesories;
    ArrayList<Product> CablesAccesories;
    ProductAdapter adapterCablesAccesories;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cables_accesroeis, container, false);
        gvCablesAccesories=view.findViewById(R.id.gvCablesAccesories);


        CablesAccesories = new ArrayList<Product>();
        CablesAccesories.add(new Product(R.drawable.cable1, "CUSTOM CASE",190000, 5F,"(12)"));
        CablesAccesories.add(new Product(R.drawable.cable2, "CUSTOM CASE",190000, 4F,"(12)"));
        CablesAccesories.add(new Product(R.drawable.cable3, "CUSTOM CASE",190000,4F,"(12)"));
        CablesAccesories.add(new Product(R.drawable.cable4, "CUSTOM CASE",190000,4F,"(12)"));
        CablesAccesories.add(new Product(R.drawable.cable5, "CUSTOM CASE",190000,4F,"(12)"));
        CablesAccesories.add(new Product(R.drawable.cable6, "CUSTOM CASE",190000,4F,"(12)"));
        CablesAccesories.add(new Product(R.drawable.cable7, "CUSTOM CASE",190000,4F,"(12)"));
        CablesAccesories.add(new Product(R.drawable.cable8, "CUSTOM CASE",190000,4F,"(12)"));
        CablesAccesories.add(new Product(R.drawable.cable9, "CUSTOM CASE",190000,4F,"(12)"));
        CablesAccesories.add(new Product(R.drawable.cable10, "CUSTOM CASE",190000,4F,"(12)"));
        CablesAccesories.add(new Product(R.drawable.cable1, "CUSTOM CASE",190000,4F,"(12)"));
        CablesAccesories.add(new Product(R.drawable.cable2, "CUSTOM CASE",190000,4F,"(12)"));

        adapterCablesAccesories = new ProductAdapter(getActivity(),R.layout.item_products,CablesAccesories);
        gvCablesAccesories.setAdapter(adapterCablesAccesories);
        return view;
    }
}