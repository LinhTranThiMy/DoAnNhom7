package com.example.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.drawermenuex.Cancelled_MyOrders;
import com.example.drawermenuex.Delivered_MyOrders;
import com.example.drawermenuex.Processing_MyOrders;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }



    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position){
            case 1:
                return new Processing_MyOrders();
            case 2:
                return new Cancelled_MyOrders();
        }
        return new Delivered_MyOrders();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
