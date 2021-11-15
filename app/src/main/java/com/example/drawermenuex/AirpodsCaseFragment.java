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


public class AirpodsCaseFragment extends Fragment {
    GridView gvAirpodCases;
    ArrayList<Product> AirpodCases;
    ProductAdapter adapterAirpodCase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_airpods_case, container, false);
        gvAirpodCases=view.findViewById(R.id.gvAirpodsCases);


        AirpodCases = new ArrayList<Product>();
        AirpodCases.add(new Product(R.drawable.airpods6, "CUSTOM CASE",190000,4F,"(12)"));
        AirpodCases.add(new Product(R.drawable.airpods8, "CUSTOM CASE",190000,4F,"(12)"));
        AirpodCases.add(new Product(R.drawable.airpods4, "CUSTOM CASE",190000,4F,"(12)"));
        AirpodCases.add(new Product(R.drawable.airpods5, "CUSTOM CASE",190000,4F,"(12)"));
        AirpodCases.add(new Product(R.drawable.airpods9, "CUSTOM CASE",190000,4F,"(12)"));
        AirpodCases.add(new Product(R.drawable.airpods10, "CUSTOM CASE",190000,4F,"(12)"));
        AirpodCases.add(new Product(R.drawable.airpods11, "CUSTOM CASE",190000,4F,"(12)"));
        AirpodCases.add(new Product(R.drawable.airpods5, "CUSTOM CASE",190000,4F,"(12)"));
        AirpodCases.add(new Product(R.drawable.airpods9, "CUSTOM CASE",190000,4F,"(12)"));
        AirpodCases.add(new Product(R.drawable.airpods11, "CUSTOM CASE",190000,4F,"(12)"));
        AirpodCases.add(new Product(R.drawable.airpods6, "CUSTOM CASE",190000,4F,"(12)"));
        AirpodCases.add(new Product(R.drawable.airpods4, "CUSTOM CASE",190000,4F,"(12)"));

        adapterAirpodCase = new ProductAdapter(getActivity(),R.layout.item_products,AirpodCases);
        gvAirpodCases.setAdapter(adapterAirpodCase);
        return view;
    }
}