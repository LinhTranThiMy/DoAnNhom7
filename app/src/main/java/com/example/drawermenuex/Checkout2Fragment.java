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

public class Checkout2Fragment extends Fragment {
    Button btnPaymentMethod;
    MaterialButton btnBackCheckOut2;
    TextView txtName,txtPhone,txtDiaChi;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_checkout2,container,false);
        linkViews();
        addEvent();
        return view;
    }

    private void linkViews() {
        btnPaymentMethod=view.findViewById(R.id.btnPaymentMethod);
        btnBackCheckOut2=view.findViewById(R.id.btnBackCheckOut2);
        txtName=view.findViewById(R.id.txtName);
        txtPhone=view.findViewById(R.id.txtPhone);
        txtDiaChi=view.findViewById(R.id.txtDiaChi);



        Bundle bundle=this.getArguments();
        if (bundle!=null) {
           String fullnameCK2 = bundle.getString("fullname");
            txtName.setText(fullnameCK2);
        }
        if (bundle!=null) {
            String phoneCK2=bundle.getString("phone");
            txtPhone.setText(phoneCK2);
        }
        if (bundle!=null) {
            String diachiCK2=bundle.getString("province")+bundle.getString("adDetail");
            txtDiaChi.setText(diachiCK2);
        }
    }

    private void addEvent() {

        btnPaymentMethod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle= new Bundle();
                bundle.putString("fullnameCK2",txtName.getText().toString());
                bundle.putString("phoneCK2",txtPhone.getText().toString());
                bundle.putString("addressCK2",txtDiaChi.getText().toString());
                Checkout3Fragment checkout3Fragment=new Checkout3Fragment();
                checkout3Fragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.layout_Checkout,checkout3Fragment).commit();
            }
        });
        btnBackCheckOut2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Checkout1Fragment checkout1Fragment=new Checkout1Fragment();
                getFragmentManager().beginTransaction().replace(R.id.layout_Checkout,checkout1Fragment).commit();
            }
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction= getParentFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
