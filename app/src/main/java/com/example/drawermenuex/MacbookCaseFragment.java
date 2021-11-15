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

public class MacbookCaseFragment extends Fragment {

    GridView gvMacbookCases;
    ArrayList<Product> MacbookCases;
    ProductAdapter adapterMacbookCase;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_macbook_case, container, false);
        gvMacbookCases=view.findViewById(R.id.gvMacbookCases);


        MacbookCases = new ArrayList<Product>();
        MacbookCases.add(new Product(R.drawable.macbook2, "CUSTOM CASE",190000,4F,"(12)"));
        MacbookCases.add(new Product(R.drawable.macbook3, "CUSTOM CASE",190000,4F,"(12)"));
        MacbookCases.add(new Product(R.drawable.macbook4, "CUSTOM CASE",190000,4F,"(12)"));
        MacbookCases.add(new Product(R.drawable.macbook5, "CUSTOM CASE",190000,4F,"(12)"));
        MacbookCases.add(new Product(R.drawable.macbook6, "CUSTOM CASE",190000,4F,"(12)"));
        MacbookCases.add(new Product(R.drawable.macbook7, "CUSTOM CASE",190000,4F,"(12)"));
        MacbookCases.add(new Product(R.drawable.macbook8, "CUSTOM CASE",190000,4F,"(12)"));
        MacbookCases.add(new Product(R.drawable.macbook2, "CUSTOM CASE",190000,4F,"(12)"));
        MacbookCases.add(new Product(R.drawable.macbook5, "CUSTOM CASE",190000,4F,"(12)"));
        MacbookCases.add(new Product(R.drawable.macbook4, "CUSTOM CASE",190000,4F,"(12)"));
        MacbookCases.add(new Product(R.drawable.macbook3, "CUSTOM CASE",190000,4F,"(12)"));
        MacbookCases.add(new Product(R.drawable.macbook7, "CUSTOM CASE",190000,4F,"(12)"));

        adapterMacbookCase = new ProductAdapter(getActivity(),R.layout.item_products,MacbookCases);
        gvMacbookCases.setAdapter(adapterMacbookCase);
        return view;
    }
}