package com.example.drawermenuex;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import com.example.adapter.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;


public class MyOrderFragment extends Fragment {
    TabLayout tabLayout;
    ViewPager2 viewPager;
    ViewPagerAdapter adapter;
    ImageButton btnBack;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view = inflater.inflate(R.layout.fragment_my_orders, container, false);
        //Hiện actionBar
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        linkViews();
        addEvents();
        tabLayout.addTab(tabLayout.newTab().setText("Deliveried"));
        tabLayout.addTab(tabLayout.newTab().setText("Processing"));
        tabLayout.addTab(tabLayout.newTab().setText("Cancelled"));
        return view;
    }

    private void linkViews() {
        tabLayout=view.findViewById(R.id.tabLayout);
        viewPager=view.findViewById(R.id.viewPager);
        btnBack=view.findViewById(R.id.btnBack);
//chua dung
        adapter = new ViewPagerAdapter(getActivity());
        viewPager.setAdapter(adapter);


    }

    private void addEvents() {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {

            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }

        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new AccountFragment());
            }
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }
}