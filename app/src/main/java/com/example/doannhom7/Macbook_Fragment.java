package com.example.doannhom7;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.adapter.ProductAdapter;
import com.example.model.Product;

import java.util.ArrayList;


public class Macbook_Fragment extends Fragment {

    GridView gvCase;
    ProductAdapter productAdapter;
    ArrayList<Product> products;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_airpods_, container, false);
        gvCase = view.findViewById(R.id.gvCase);
        products=new ArrayList<>();
        products.add((new Product(R.drawable.macbook1,"Custom Case", 190000)));
        products.add((new Product(R.drawable.macbook3,"Custom Case", 190000)));
        products.add((new Product(R.drawable.macbook2,"Custom Case", 190000)));
        products.add((new Product(R.drawable.macbook4,"Custom Case", 190000)));
        products.add((new Product(R.drawable.macbook6,"Custom Case", 190000)));
        products.add((new Product(R.drawable.macbook5,"Custom Case", 190000)));
        products.add((new Product(R.drawable.macbook4,"Custom Case", 190000)));
        products.add((new Product(R.drawable.macbook7,"Custom Case", 190000)));
        products.add((new Product(R.drawable.macbook8,"Custom Case", 190000)));
        productAdapter = new ProductAdapter(getActivity(),R.layout.item_products,products);
        gvCase.setAdapter(productAdapter);

        return view;
    }
}