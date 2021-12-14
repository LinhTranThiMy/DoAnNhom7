package com.example.drawermenuex;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class ProductDescriptionFragment extends Fragment {

    public static TextView txtDescription;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.frgament_product_description, container, false);
        //linkViews
        txtDescription=view.findViewById(R.id.txtDescription);


        return view;
    }
}