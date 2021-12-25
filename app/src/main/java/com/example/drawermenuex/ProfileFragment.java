package com.example.drawermenuex;

import static com.example.util.Constant.USER;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.model.Product;
import com.example.util.Constant;


public class ProfileFragment extends Fragment {
    Button btnMyAccount,btnPassword;
    ImageButton btnBackProfile;
    String mPassUser;

    public ProfileFragment(String passUser) {
        this.mPassUser = passUser;
    }
    public ProfileFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_profile,container,false);
        //Ẩn actionBar
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();

        btnMyAccount=view.findViewById(R.id.btnMyAccount);
        btnPassword=view.findViewById(R.id.btnPassword);
        btnBackProfile=view.findViewById(R.id.btnBackProfile);
        btnMyAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = getArguments();
                if(bundle != null)
                {
                    String key = bundle.getString(USER);
                    bundle.putSerializable(USER, key);
                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    DetailAccountFragment fragment = new DetailAccountFragment();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,fragment).addToBackStack(null).commit();
                    bundle.putSerializable(USER, key);
                    fragment.setArguments(bundle);
                }

//                Intent intent= new Intent(getContext(),ProfileMyAccount1.class);
//                intent.putExtra(USER, mPassUser);
//                startActivity(intent);
            }
        });
        btnPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = getArguments();
                if(bundle != null) {
                    String key = bundle.getString(USER);
                    bundle.putSerializable(USER, key);
                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    ProfilePassword1Fragment fragment = new ProfilePassword1Fragment();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).addToBackStack(null).commit();
                    bundle.putSerializable(USER, key);
                    fragment.setArguments(bundle);
                }
            }
        });
        btnBackProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = getArguments();
                if(bundle != null) {
                    String key = bundle.getString(USER);
                    bundle.putSerializable(USER, key);
                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    AccountFragment fragment = new AccountFragment();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).addToBackStack(null).commit();
                    bundle.putSerializable(USER, key);
                    fragment.setArguments(bundle);
                }
            }
        });
        return view;
    }
    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction= getParentFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }
}