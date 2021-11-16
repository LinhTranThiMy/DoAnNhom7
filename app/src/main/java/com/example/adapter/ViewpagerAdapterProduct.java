package com.example.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.doannhom7.Airpods_Fragment;
import com.example.doannhom7.Cases_Fragment;
import com.example.doannhom7.Ipad_Fragment;
import com.example.doannhom7.Iphone_Fragment;
import com.example.doannhom7.Macbook_Fragment;


public class ViewpagerAdapterProduct extends FragmentStateAdapter {


    public ViewpagerAdapterProduct(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1:
                return new Iphone_Fragment();
            case 2:
                return new Airpods_Fragment();
            case 3:
                return new Ipad_Fragment();
            case 4:
                return new Macbook_Fragment();
        }
       return new Cases_Fragment();
    }

    @Override
    public int getItemCount() {
        return 5;
    }


}
