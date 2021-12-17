package com.example.drawermenuex;

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


public class ProfileFragment extends Fragment {
    Button btnMyAccount,btnPassword;
    ImageButton btnBackProfile;
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
                Intent intent= new Intent(getContext(),ProfileMyAccount1.class);
                startActivity(intent);
            }
        });
        btnPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new ProfilePassword1Fragment());
            }
        });
        btnBackProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new AccountFragment());
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