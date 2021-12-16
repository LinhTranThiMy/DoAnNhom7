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

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.adapter.ViewPagerAdapterAccesories;
import com.example.adapter.ViewPagerAdapterCase;
import com.google.android.material.tabs.TabLayout;


public class AccessoriesFragment extends Fragment {
    TabLayout tabLayoutAccesories;
    ViewPager2 viewPagerAccesories;
    ViewPagerAdapterAccesories adapterAccesories;
    Button btnFilter,btnCancel, btnApply;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_accessories, container, false);
        //Hiện actionBar
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();

        tabLayoutAccesories=view.findViewById(R.id.tabLayoutAccesories);
        viewPagerAccesories=view.findViewById(R.id.viewPagerAccesories);
        btnFilter=view.findViewById(R.id.btnFilter);

        tabLayoutAccesories.addTab(tabLayoutAccesories.newTab().setText("All"));
        tabLayoutAccesories.addTab(tabLayoutAccesories.newTab().setText("Cables"));
        tabLayoutAccesories.addTab(tabLayoutAccesories.newTab().setText("Charger"));
        tabLayoutAccesories.addTab(tabLayoutAccesories.newTab().setText("Power Bank"));
        tabLayoutAccesories.addTab(tabLayoutAccesories.newTab().setText("Others"));
        adapterAccesories = new ViewPagerAdapterAccesories(getActivity());
        viewPagerAccesories.setAdapter(adapterAccesories);

        tabLayoutAccesories.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPagerAccesories.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPagerAccesories.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayoutAccesories.selectTab(tabLayoutAccesories.getTabAt(position));
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