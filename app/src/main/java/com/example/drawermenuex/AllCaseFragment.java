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


public class AllCaseFragment extends Fragment {
    GridView gvAllCases;
    ArrayList<Product> AllCases;
    ProductAdapter adapterAllCase;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_case, container, false);
        gvAllCases=view.findViewById(R.id.gvAllCase);


        AllCases = new ArrayList<Product>();
        AllCases.add(new Product(R.drawable.case1, "CUSTOM CASE",190000, 5F,"(12)"));
        AllCases.add(new Product(R.drawable.ipad8, "CUSTOM CASE",190000, 4F,"(12)"));
        AllCases.add(new Product(R.drawable.macbook3, "CUSTOM CASE",190000,4F,"(12)"));
        AllCases.add(new Product(R.drawable.airpods5, "CUSTOM CASE",190000,4F,"(12)"));
        AllCases.add(new Product(R.drawable.case5, "CUSTOM CASE",190000,4F,"(12)"));
        AllCases.add(new Product(R.drawable.ipad4, "CUSTOM CASE",190000,4F,"(12)"));
        AllCases.add(new Product(R.drawable.macbook4, "CUSTOM CASE",190000,4F,"(12)"));
        AllCases.add(new Product(R.drawable.airpods9, "CUSTOM CASE",190000,4F,"(12)"));
        AllCases.add(new Product(R.drawable.case3, "CUSTOM CASE",190000,4F,"(12)"));
        AllCases.add(new Product(R.drawable.ipad5, "CUSTOM CASE",190000,4F,"(12)"));
        AllCases.add(new Product(R.drawable.airpods6, "CUSTOM CASE",190000,4F,"(12)"));
        AllCases.add(new Product(R.drawable.macbook2, "CUSTOM CASE",190000,4F,"(12)"));

        adapterAllCase = new ProductAdapter(getActivity(),R.layout.item_products,AllCases);
        gvAllCases.setAdapter(adapterAllCase);
        return view;
    }
}