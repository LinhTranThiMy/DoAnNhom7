package com.example.drawermenuex;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adapter.ProductAdapter;
import com.example.adapter.ProductDetailsAdapter;
import com.example.interfaces.ProductInterface;
import com.example.model.Product;
import com.example.model.ProductDetailsBanner;
import com.example.util.Constant;

import java.util.ArrayList;
import java.util.List;


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
        adapterAllCase = new ProductAdapter(getActivity(),R.layout.item_products,initData());
        gvAllCases.setAdapter(adapterAllCase);
        gvAllCases.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        return view;
    }

    private List<Product> initData() {
        AllCases = new ArrayList<Product>();
        AllCases.add(new Product(R.drawable.case1, "GIRLIE CASE",190000, 5F,"(11)"));
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
        return AllCases;
    }



}