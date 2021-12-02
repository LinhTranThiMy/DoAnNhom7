package com.example.drawermenuex;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.adapter.ProductAdapter;
import com.example.model.Product;

import java.util.ArrayList;
import java.util.List;


public class CollectionFragment extends Fragment {
    GridView gvNewArrivals, gvPopular, gvSaleOff;
    ArrayList<Product> NewArrivals,Popular,SaleOff;
    ProductAdapter adapterNewArrivals,adapterPopular,adapterSaleOff;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_collection, container, false);
        //Hiện actionBar
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        //linkViews
        gvNewArrivals=view.findViewById(R.id.gvNewArrivals);
        gvPopular=view.findViewById(R.id.gvPopular);
        gvSaleOff=view.findViewById(R.id.gvSaleOff);

        NewArrivals = new ArrayList<Product>();
        NewArrivals.add(new Product(R.drawable.case1, "GIRLIE CASE",190000, 5F,"(11)"));
        NewArrivals.add(new Product(R.drawable.ipad8, "CUSTOM CASE",190000, 4F,"(12)"));
        NewArrivals.add(new Product(R.drawable.macbook3, "CUSTOM CASE",190000,4F,"(12)"));
        NewArrivals.add(new Product(R.drawable.airpods5, "CUSTOM CASE",190000,4F,"(12)"));
        NewArrivals.add(new Product(R.drawable.case5, "CUSTOM CASE",190000,4F,"(12)"));
        NewArrivals.add(new Product(R.drawable.ipad4, "CUSTOM CASE",190000,4F,"(12)"));
        adapterNewArrivals = new ProductAdapter(getActivity(),R.layout.item_products,NewArrivals);
        gvNewArrivals.setAdapter(adapterNewArrivals);

        Popular = new ArrayList<Product>();
        Popular.add(new Product(R.drawable.case1, "GIRLIE CASE",190000, 5F,"(11)"));
        Popular.add(new Product(R.drawable.ipad8, "CUSTOM CASE",190000, 4F,"(12)"));
        Popular.add(new Product(R.drawable.macbook3, "CUSTOM CASE",190000,4F,"(12)"));
        Popular.add(new Product(R.drawable.airpods5, "CUSTOM CASE",190000,4F,"(12)"));
        Popular.add(new Product(R.drawable.case5, "CUSTOM CASE",190000,4F,"(12)"));
        Popular.add(new Product(R.drawable.ipad4, "CUSTOM CASE",190000,4F,"(12)"));
        adapterPopular = new ProductAdapter(getActivity(),R.layout.item_products,Popular);
        gvPopular.setAdapter(adapterPopular);

        SaleOff = new ArrayList<Product>();
        SaleOff.add(new Product(R.drawable.case1, "GIRLIE CASE",190000, 5F,"(11)"));
        SaleOff.add(new Product(R.drawable.ipad8, "CUSTOM CASE",190000, 4F,"(12)"));
        SaleOff.add(new Product(R.drawable.macbook3, "CUSTOM CASE",190000,4F,"(12)"));
        SaleOff.add(new Product(R.drawable.airpods5, "CUSTOM CASE",190000,4F,"(12)"));
        SaleOff.add(new Product(R.drawable.case5, "CUSTOM CASE",190000,4F,"(12)"));
        SaleOff.add(new Product(R.drawable.ipad4, "CUSTOM CASE",190000,4F,"(12)"));
        adapterSaleOff = new ProductAdapter(getActivity(),R.layout.item_products,Popular);
        gvSaleOff.setAdapter(adapterSaleOff);
        return view;
    }


}