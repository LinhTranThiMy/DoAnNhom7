package com.example.drawermenuex;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adapter.MyCartAdapter;
import com.example.interfaces.ICartLoadListener;
import com.example.model.CartModel;
import com.example.model.Product;
import com.example.util.Constant;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Checkout3Fragment extends Fragment implements ICartLoadListener {

    @BindView(R.id.txtSubTotal)
    TextView txtSubTotal;
    @BindView(R.id.txtTotal)
    TextView txtTotal;
    @BindView(R.id.txtShipping)
    TextView txtShipping;


    Button btnConfirmCheckOut3;
    MaterialButton btnBackCheckOut3;
    TextView txtName,txtPhone,txtDiaChi;
    Product p;

    @BindView(R.id.recycler_final)
    RecyclerView recycler_final;

    ICartLoadListener cartLoadListener;

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_checkout3,container,false);
        linkViews();
        addEvent();
        loadCartFromFireBase();

        cartLoadListener = this;
        ButterKnife.bind(this, view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(),
                LinearLayoutManager.VERTICAL,false);
        recycler_final.setLayoutManager(linearLayoutManager);
        recycler_final.addItemDecoration(new DividerItemDecoration(view.getContext(),
                linearLayoutManager.getOrientation()));

        return view;
    }

    private void loadCartFromFireBase() {
        List<CartModel> cartModels = new ArrayList<>();
        FirebaseDatabase.getInstance()
                .getReference("Cart")
                .child("UNIQUE_USER_ID")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        if(snapshot.exists()) {
                            for (DataSnapshot cartSnapshot : snapshot.getChildren()) {
                                CartModel cartModel = cartSnapshot.getValue(CartModel.class);
                                cartModel.setKey(cartSnapshot.getKey());
                                cartModels.add(cartModel);
                            }
                            cartLoadListener.onCartLoadSuccess(cartModels);
                        }
                        else
                        {
                            cartLoadListener.onCartLoadFailed("Cart Empty");
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                        cartLoadListener.onCartLoadFailed(error.getMessage());
                    }
                });
    }

    private void linkViews() {
        btnConfirmCheckOut3=view.findViewById(R.id.btnConfirmCheckOut3);
        btnBackCheckOut3=view.findViewById(R.id.btnBackCheckOut3);
        txtName=view.findViewById(R.id.txtNameCK3);
        txtPhone=view.findViewById(R.id.txtPhoneCK3);
        txtDiaChi=view.findViewById(R.id.txtDiaChiCK3);

        Bundle bundle = this.getArguments();
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
//                replaceFragment(new Checkout2Fragment());
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

    @Override
    public void onCartLoadSuccess(List<CartModel> cartModelList) {
        double sum = 0;
        for(CartModel cartModel : cartModelList) {
            sum += cartModel.getTotalPrice();
        }
        double sum1 = 0;
        if(sum < 150000)
        {
            sum1 += 30000;
        }
        double sum2 = sum + sum1;
        txtSubTotal.setText(new StringBuilder().append(sum));
        txtTotal.setText(new StringBuilder("").append(sum2));
        txtShipping.setText(new StringBuilder("").append(sum1));
        MyCartAdapter adapter = new MyCartAdapter(getContext(), cartModelList);
        recycler_final.setAdapter(adapter);
        Toast.makeText(getContext(), "Success!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCartLoadFailed(String message) {
        Toast.makeText(getContext(), "Failed!", Toast.LENGTH_SHORT).show();

    }
}
