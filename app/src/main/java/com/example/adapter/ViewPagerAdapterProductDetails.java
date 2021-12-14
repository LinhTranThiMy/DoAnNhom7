package com.example.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.drawermenuex.ProductDescriptionFragment;
import com.example.drawermenuex.ReviewFragment;

public class ViewPagerAdapterProductDetails extends FragmentStateAdapter {
    public ViewPagerAdapterProductDetails(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1:
                return new ReviewFragment();
        }
        return new ProductDescriptionFragment();

    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
