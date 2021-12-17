package com.example.drawermenuex;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.button.MaterialButton;

public class Checkout3Fragment extends Fragment {
    Button btnConfirmCheckOut3;
    MaterialButton btnBackCheckOut3;
    TextView txtName,txtPhone,txtDiaChi;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_checkout3,container,false);
        linkViews();
        addEvent();

        return view;
    }

    private void linkViews() {
        btnConfirmCheckOut3=view.findViewById(R.id.btnConfirmCheckOut3);
        btnBackCheckOut3=view.findViewById(R.id.btnBackCheckOut3);
        txtName=view.findViewById(R.id.txtNameCK3);
        txtPhone=view.findViewById(R.id.txtPhoneCK3);
        txtDiaChi=view.findViewById(R.id.txtDiaChiCK3);

        Bundle bundle=this.getArguments();
        String fullnameCK3=bundle.getString("fullnameCK2");
        txtName.setText(fullnameCK3);
        String phoneCK3=bundle.getString("phoneCK2");
        txtPhone.setText(phoneCK3);
        String diachiCK3=bundle.getString("addressCK2");
        txtDiaChi.setText(diachiCK3);


    }

    private void addEvent() {
        btnConfirmCheckOut3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                replaceFragment(new CheckoutConfirmFragment());
                CheckoutConfirmFragment checkoutConfirmFragment=new CheckoutConfirmFragment();
                getFragmentManager().beginTransaction().replace(R.id.layout_Checkout,checkoutConfirmFragment).commit();
            }
        });
        btnBackCheckOut3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Checkout2Fragment checkout2Fragment=new Checkout2Fragment();
                getFragmentManager().beginTransaction().replace(R.id.layout_Checkout,checkout2Fragment).commit();
            }
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction= getParentFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }
}
