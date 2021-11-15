package com.example.drawermenuex;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.adapter.ViewPagerAdapterAccesories;
import com.example.adapter.ViewPagerAdapterCase;
import com.google.android.material.tabs.TabLayout;


public class AccessoriesFragment extends Fragment {
    TabLayout tabLayoutAccesories;
    ViewPager2 viewPagerAccesories;
    ViewPagerAdapterAccesories adapterAccesories;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_accessories, container, false);
        tabLayoutAccesories=view.findViewById(R.id.tabLayoutAccesories);
        viewPagerAccesories=view.findViewById(R.id.viewPagerAccesories);


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
        return view;
    }
}