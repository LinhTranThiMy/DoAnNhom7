package com.example.drawermenuex;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.adapter.MyCartAdapter;
import com.example.interfaces.ICartLoadListener;
import com.example.model.CartModel;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CartFragment extends Fragment implements ICartLoadListener {
    @BindView(R.id.recycler_cart)
    RecyclerView recyclerCart;
    @BindView(R.id.mainLayout)
    LinearLayout mainLayout;
    @BindView(R.id.txtSubTotal)
    TextView txtSubTotal;
    @BindView(R.id.txtTotal)
    TextView txtTotal;
    @BindView(R.id.txtShipping)
    TextView txtShipping;
    @BindView(R.id.btnCheckOut)
    Button btnCheckOut;

    ICartLoadListener cartLoadListener;
    private View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.fragment_cart, container, false);
        //Ẩn actionBar
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();

        cartLoadListener = this;
        ButterKnife.bind(this, view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(),
                LinearLayoutManager.VERTICAL,false);
        recyclerCart.setLayoutManager(linearLayoutManager);
        recyclerCart.addItemDecoration(new DividerItemDecoration(view.getContext(),
                linearLayoutManager.getOrientation()));
        loadCartFromFireBase();
        addEvents();
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


    private void addEvents() {
        btnCheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getContext(),CheckoutActivity.class);
                startActivity(intent);
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
        //Tổng tiền
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
        recyclerCart.setAdapter(adapter);
    }

    @Override
    public void onCartLoadFailed(String message) {
        Snackbar.make(mainLayout, message, Snackbar.LENGTH_LONG).show();
    }
}
