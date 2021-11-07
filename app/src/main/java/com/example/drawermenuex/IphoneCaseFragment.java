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


public class IphoneCaseFragment extends Fragment {
    GridView gvIphoneCases;
    ArrayList<Product> IphoneCases;
    ProductAdapter adapterIphoneCase;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_iphone_case, container, false);
        gvIphoneCases=view.findViewById(R.id.gvIphoneCases);


        IphoneCases = new ArrayList<Product>();
        IphoneCases.add(new Product(R.drawable.case1, "CUSTOM CASE",190000));
        IphoneCases.add(new Product(R.drawable.case2, "CUSTOM CASE",190000));
        IphoneCases.add(new Product(R.drawable.case3, "CUSTOM CASE",190000));
        IphoneCases.add(new Product(R.drawable.case4, "CUSTOM CASE",190000));
        IphoneCases.add(new Product(R.drawable.case5, "CUSTOM CASE",190000));
        IphoneCases.add(new Product(R.drawable.case1, "CUSTOM CASE",190000));
        IphoneCases.add(new Product(R.drawable.case1, "CUSTOM CASE",190000));
        IphoneCases.add(new Product(R.drawable.case2, "CUSTOM CASE",190000));
        IphoneCases.add(new Product(R.drawable.case3, "CUSTOM CASE",190000));
        IphoneCases.add(new Product(R.drawable.case4, "CUSTOM CASE",190000));
        IphoneCases.add(new Product(R.drawable.case5, "CUSTOM CASE",190000));
        IphoneCases.add(new Product(R.drawable.case1, "CUSTOM CASE",190000));

        adapterIphoneCase = new ProductAdapter(getActivity(),R.layout.item_products,IphoneCases);
        gvIphoneCases.setAdapter(adapterIphoneCase);
        return view;
    }
}