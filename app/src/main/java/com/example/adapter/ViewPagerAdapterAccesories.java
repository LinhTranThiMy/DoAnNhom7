package com.example.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.drawermenuex.AllAccesoriesFragment;
import com.example.drawermenuex.CablesAccesroeisFragment;
import com.example.drawermenuex.ChargerAccesoriesFragment;
import com.example.drawermenuex.OthersAccesoriesFragment;
import com.example.drawermenuex.PowerBankAccesoriesFragment;

public class ViewPagerAdapterAccesories extends FragmentStateAdapter {
    public ViewPagerAdapterAccesories(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1:
                return new CablesAccesroeisFragment();
            case 2:
                return new ChargerAccesoriesFragment();
            case 3:
                return new PowerBankAccesoriesFragment();
            case 4:
                return new OthersAccesoriesFragment();
        }
        return new AllAccesoriesFragment();

    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
