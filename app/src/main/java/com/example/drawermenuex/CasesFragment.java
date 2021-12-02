package com.example.drawermenuex;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.adapter.ProductAdapter;
import com.example.adapter.ViewPagerAdapterCase;
import com.example.model.Product;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class CasesFragment extends Fragment {

    TabLayout tabLayoutCase;
    ViewPager2 viewPagerCase;
    ViewPagerAdapterCase adapterCase;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cases, container, false);
        //Hiện actionBar
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();

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
        return view;
    }
}