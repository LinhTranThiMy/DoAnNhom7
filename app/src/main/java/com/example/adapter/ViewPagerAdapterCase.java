package com.example.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.drawermenuex.AirpodsCaseFragment;
import com.example.drawermenuex.AllCaseFragment;
import com.example.drawermenuex.IpadCaseFragment;
import com.example.drawermenuex.IphoneCaseFragment;
import com.example.drawermenuex.MacbookCaseFragment;

public class ViewPagerAdapterCase extends FragmentStateAdapter {

    public ViewPagerAdapterCase(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1:
                return new IphoneCaseFragment();
            case 2:
                return new AirpodsCaseFragment();
            case 3:
                return new IpadCaseFragment();
            case 4:
                return new MacbookCaseFragment();
        }
        return new AllCaseFragment();
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
