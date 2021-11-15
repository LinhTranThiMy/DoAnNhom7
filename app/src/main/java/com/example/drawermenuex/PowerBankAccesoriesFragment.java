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


public class PowerBankAccesoriesFragment extends Fragment {
    GridView gvPowerBankAccesories;
    ArrayList<Product> PowerBankAccesories;
    ProductAdapter adapterPowerBankAccesories;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_power_bank_accesories, container, false);
        gvPowerBankAccesories=view.findViewById(R.id.gvPowerBankAccesories);


        PowerBankAccesories = new ArrayList<Product>();
        PowerBankAccesories.add(new Product(R.drawable.powerbank1, "CUSTOM CASE",190000, 5F,"(12)"));
        PowerBankAccesories.add(new Product(R.drawable.powerbank2, "CUSTOM CASE",190000, 4F,"(12)"));
        PowerBankAccesories.add(new Product(R.drawable.powerbank3, "CUSTOM CASE",190000,4F,"(12)"));
        PowerBankAccesories.add(new Product(R.drawable.powerbank4, "CUSTOM CASE",190000,4F,"(12)"));
        PowerBankAccesories.add(new Product(R.drawable.powerbank5, "CUSTOM CASE",190000,4F,"(12)"));
        PowerBankAccesories.add(new Product(R.drawable.powerbank6, "CUSTOM CASE",190000,4F,"(12)"));
        PowerBankAccesories.add(new Product(R.drawable.powerbank7, "CUSTOM CASE",190000,4F,"(12)"));
        PowerBankAccesories.add(new Product(R.drawable.powerbank8, "CUSTOM CASE",190000,4F,"(12)"));
        PowerBankAccesories.add(new Product(R.drawable.powerbank9, "CUSTOM CASE",190000,4F,"(12)"));
        PowerBankAccesories.add(new Product(R.drawable.powerbank10, "CUSTOM CASE",190000,4F,"(12)"));
        PowerBankAccesories.add(new Product(R.drawable.powerbank1, "CUSTOM CASE",190000,4F,"(12)"));
        PowerBankAccesories.add(new Product(R.drawable.powerbank2, "CUSTOM CASE",190000,4F,"(12)"));

        adapterPowerBankAccesories = new ProductAdapter(getActivity(),R.layout.item_products,PowerBankAccesories);
        gvPowerBankAccesories.setAdapter(adapterPowerBankAccesories);
        return view;
    }
}