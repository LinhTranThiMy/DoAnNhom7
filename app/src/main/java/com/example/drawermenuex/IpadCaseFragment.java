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


public class IpadCaseFragment extends Fragment {
    GridView gvIpadCases;
    ArrayList<Product> IpadCases;
    ProductAdapter adapterIpadCase;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ipad_case, container, false);
        gvIpadCases=view.findViewById(R.id.gvIpadCases);


        IpadCases = new ArrayList<Product>();
        IpadCases.add(new Product(R.drawable.ipad3, "CUSTOM CASE",190000));
        IpadCases.add(new Product(R.drawable.ipad4, "CUSTOM CASE",190000));
        IpadCases.add(new Product(R.drawable.ipad5, "CUSTOM CASE",190000));
        IpadCases.add(new Product(R.drawable.ipad6, "CUSTOM CASE",190000));
        IpadCases.add(new Product(R.drawable.ipad7, "CUSTOM CASE",190000));
        IpadCases.add(new Product(R.drawable.ipad8, "CUSTOM CASE",190000));
        IpadCases.add(new Product(R.drawable.ipad3, "CUSTOM CASE",190000));
        IpadCases.add(new Product(R.drawable.ipad4, "CUSTOM CASE",190000));
        IpadCases.add(new Product(R.drawable.ipad5, "CUSTOM CASE",190000));
        IpadCases.add(new Product(R.drawable.ipad6, "CUSTOM CASE",190000));
        IpadCases.add(new Product(R.drawable.ipad7, "CUSTOM CASE",190000));
        IpadCases.add(new Product(R.drawable.ipad8, "CUSTOM CASE",190000));

        adapterIpadCase = new ProductAdapter(getActivity(),R.layout.item_products,IpadCases);
        gvIpadCases.setAdapter(adapterIpadCase);
        return view;
    }
}