package com.example.drawermenuex;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class AccountFragment extends Fragment {
    Button btnProfile,btnPoints,btnMyOrder,btnLogOut;
    String mPassUser;
    public AccountFragment(String passUser) {
        this.mPassUser = passUser;
    }

    public AccountFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_account,container,false);
        //Hiện actionBar
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();

        btnProfile=view.findViewById(R.id.btnProfile);
        btnPoints=view.findViewById(R.id.btnPoints);
        btnMyOrder=view.findViewById(R.id.btnMyOrder);
        btnLogOut=view.findViewById(R.id.btnLogOut);
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment( new ProfileFragment(mPassUser));
            }
        });
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConfirmDangXuat();


            }
        });
        btnPoints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new PointFragment());
            }
        });
        btnMyOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               replaceFragment(new MyOrderFragment());
            }
        });
        return view;
    }
    private void ConfirmDangXuat(){
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(getContext());
        alertDialog.setTitle("CONFIRMATION!");
        alertDialog.setMessage("Are you sure you want to log out ?");
        alertDialog.setIcon(R.drawable.ic_baseline_warning_24);
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Intent intent= new Intent(getActivity(),LoginActivity.class);
                startActivity(intent);
            }
        });
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
            dialog.dismiss();
            }
        });
        alertDialog.show();
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction= getParentFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }
}