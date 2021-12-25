package com.example.drawermenuex;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.button.MaterialButton;

public class Processing_OrderDetails extends Fragment {
    MaterialButton btnCancelOrder;
    private View view;
    ImageButton btnClose;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.activity_processing_order_details, container, false);
        //Ẩn actionBar
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        btnClose=view.findViewById(R.id.btnCloseP);
        btnCancelOrder=view.findViewById(R.id.btnCancelOrder);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().popBackStack();
            }
        });
        btnCancelOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new CancelledReasonFragment());
            }
        });
        return view;

    }
    private void replaceFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment).addToBackStack(null);
        fragmentTransaction.commit();
    }
}