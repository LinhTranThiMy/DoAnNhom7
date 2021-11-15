package com.example.drawermenuex;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.imageview.ShapeableImageView;


public class SearchFragment<replaceFragment> extends Fragment {
    ImageView imvbtnCase,imvbtnCollection,imvbtnAccessories;
    FragmentManager manager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        imvbtnCase=view.findViewById(R.id.imvbtnCase);
        imvbtnAccessories = view.findViewById(R.id.imvbtnAccessories);
        imvbtnCollection=view.findViewById(R.id.imvbtnCollection);

        imvbtnCase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        imvbtnAccessories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;
    }



}