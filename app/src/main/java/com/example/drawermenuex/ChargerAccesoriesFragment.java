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


public class ChargerAccesoriesFragment extends Fragment {
    GridView gvChargerAccesories;
    ArrayList<Product> ChargerAccesories;
    ProductAdapter adapterChargerAccesories;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_charger_accesories, container, false);
        gvChargerAccesories=view.findViewById(R.id.gvChargerAccesories);


        ChargerAccesories = new ArrayList<Product>();
        ChargerAccesories.add(new Product(R.drawable.charger1, "CUSTOM CASE",190000, 5F,"(12)"));
        ChargerAccesories.add(new Product(R.drawable.charger2, "CUSTOM CASE",190000, 4F,"(12)"));
        ChargerAccesories.add(new Product(R.drawable.charger3, "CUSTOM CASE",190000,4F,"(12)"));
        ChargerAccesories.add(new Product(R.drawable.charger4, "CUSTOM CASE",190000,4F,"(12)"));
        ChargerAccesories.add(new Product(R.drawable.charger5, "CUSTOM CASE",190000,4F,"(12)"));
        ChargerAccesories.add(new Product(R.drawable.charger6, "CUSTOM CASE",190000,4F,"(12)"));
        ChargerAccesories.add(new Product(R.drawable.charger7, "CUSTOM CASE",190000,4F,"(12)"));
        ChargerAccesories.add(new Product(R.drawable.charger8, "CUSTOM CASE",190000,4F,"(12)"));
        ChargerAccesories.add(new Product(R.drawable.charger9, "CUSTOM CASE",190000,4F,"(12)"));
        ChargerAccesories.add(new Product(R.drawable.charger10, "CUSTOM CASE",190000,4F,"(12)"));
        ChargerAccesories.add(new Product(R.drawable.charger1, "CUSTOM CASE",190000,4F,"(12)"));
        ChargerAccesories.add(new Product(R.drawable.charger2, "CUSTOM CASE",190000,4F,"(12)"));

        adapterChargerAccesories = new ProductAdapter(getActivity(),R.layout.item_products,ChargerAccesories);
        gvChargerAccesories.setAdapter(adapterChargerAccesories);
        return view;
    }
}