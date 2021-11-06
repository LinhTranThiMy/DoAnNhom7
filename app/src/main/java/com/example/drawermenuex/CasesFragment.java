package com.example.drawermenuex;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.fragment.app.Fragment;

import com.example.adapter.ProductAdapter;
import com.example.model.Product;

import java.util.ArrayList;


public class CasesFragment extends Fragment {
    GridView gvProduct;
    ArrayList<Product> products;
    ProductAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cases, container, false);
        gvProduct=view.findViewById(R.id.gvProduct);


        products = new ArrayList<Product>();
        products.add(new Product(R.drawable.case1, "CUSTOM CASE",190000));
        products.add(new Product(R.drawable.case2, "CUSTOM CASE",190000));
        products.add(new Product(R.drawable.case3, "CUSTOM CASE",190000));
        products.add(new Product(R.drawable.case4, "CUSTOM CASE",190000));
        products.add(new Product(R.drawable.case5, "CUSTOM CASE",190000));
        products.add(new Product(R.drawable.case1, "CUSTOM CASE",190000));
        products.add(new Product(R.drawable.case1, "CUSTOM CASE",190000));
        products.add(new Product(R.drawable.case2, "CUSTOM CASE",190000));
        products.add(new Product(R.drawable.case3, "CUSTOM CASE",190000));
        products.add(new Product(R.drawable.case4, "CUSTOM CASE",190000));
        products.add(new Product(R.drawable.case5, "CUSTOM CASE",190000));
        products.add(new Product(R.drawable.case1, "CUSTOM CASE",190000));

        adapter = new ProductAdapter(getActivity(),R.layout.item_products,products);
        gvProduct.setAdapter(adapter);
        return view;
    }
}