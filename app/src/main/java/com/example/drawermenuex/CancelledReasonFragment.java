package com.example.drawermenuex;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class CancelledReasonFragment extends Fragment {
    Button btnSubmit;
    Spinner spCancelRequest;
    ArrayList<String> reasons;
    ArrayAdapter<String> adapter;
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_cancelled__my_orders, container, false);
        linkViews();
        initData();
        loadData();
        addEvents();
        return view;
    }

    private void linkViews() {
        spCancelRequest = view.findViewById(R.id.spCancelRequest);
        btnSubmit=view.findViewById(R.id.btnSubmit);
    }

    private void addEvents() {
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            replaceFragment(new HomeFragment());
            }
        });
    }

    private void initData() {
        reasons = new ArrayList<String>();
        reasons.add("Select reason");
        reasons.add("I have changed my mind");
        reasons.add("I bought the wrong item(s)");
        reasons.add("I placed a duplicate order");
        reasons.add("I received negative feedback about the item after purchase");
        reasons.add("Delivery takes too long");
        reasons.add("I want to change payment method");
        reasons.add("Other");
    }

    private void loadData() {
        adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, reasons);
        spCancelRequest.setAdapter(adapter);
    }
    private void replaceFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }
}