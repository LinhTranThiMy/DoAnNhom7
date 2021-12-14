package com.example.drawermenuex;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.adapter.ProductAdapter;
import com.example.adapter.ViewPagerAdapterCase;
import com.example.model.Product;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class CasesFragment extends Fragment {

    TabLayout tabLayoutCase;
    ViewPager2 viewPagerCase;
    ViewPagerAdapterCase adapterCase;
    Button btnFilter, btnCancel, btnApply;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cases, container, false);
        //Hiện actionBar
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        btnFilter=view.findViewById(R.id.btnFilter);

        tabLayoutCase=view.findViewById(R.id.tabLayoutCase);
        viewPagerCase=view.findViewById(R.id.viewPagerCase);


        tabLayoutCase.addTab(tabLayoutCase.newTab().setText("All"));
        tabLayoutCase.addTab(tabLayoutCase.newTab().setText("Iphone"));
        tabLayoutCase.addTab(tabLayoutCase.newTab().setText("Airpods"));
        tabLayoutCase.addTab(tabLayoutCase.newTab().setText("Ipad"));
        tabLayoutCase.addTab(tabLayoutCase.newTab().setText("Macbook"));
        adapterCase = new ViewPagerAdapterCase(getActivity());
        viewPagerCase.setAdapter(adapterCase);

        tabLayoutCase.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPagerCase.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPagerCase.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayoutCase.selectTab(tabLayoutCase.getTabAt(position));
            }
        });
        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFilterDialog();
            }
        });


        return view;
    }

    private void openFilterDialog() {
        Dialog dialog=new Dialog(getActivity());
        dialog.setContentView(R.layout.fragment_filter);
        btnCancel=dialog.findViewById(R.id.btnCancel);
        btnApply=dialog.findViewById(R.id.btnApply);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        dialog.getWindow().getAttributes().windowAnimations= R.style.Animation_AppCompat_Dialog;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

    }
}