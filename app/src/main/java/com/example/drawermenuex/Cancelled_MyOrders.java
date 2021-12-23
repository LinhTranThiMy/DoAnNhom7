package com.example.drawermenuex;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adapter.MyOrdersAdapter;
import com.example.interfaces.ItemClickListener;
import com.example.model.MyOrder;

import java.util.ArrayList;


public class Cancelled_MyOrders extends Fragment implements ItemClickListener {

    RecyclerView rcvProduct;
    MyOrdersAdapter myOrdersAdapter;
    ArrayList<MyOrder> myOrder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_cancelled__my_orders, container, false);
        rcvProduct =view.findViewById(R.id.rcvProduct);
        //Ẩn actionBar
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();

        LinearLayoutManager manager= new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        rcvProduct.setLayoutManager(manager);


        myOrder = new ArrayList<>();
        myOrder.add(new MyOrder("Track no.","IW654384JJGF","FLORAL CASE","Apple","iphone 13 Pro max","Quantity: 1","Cancelled","Bought 1 product","Total: 320000",150000, R.drawable.case1, R.drawable.ic_baseline_shopping_bag_24)); myOrder.add(new MyOrder("Track no.","IW654384JJGF","FLORAL CASE","Apple","iphone 13 Pro max","Quantity: 1","Cancelled","Bought 1 product","Total: 320000",150000, R.drawable.case1, R.drawable.ic_baseline_shopping_bag_24)); myOrder.add(new MyOrder("Track no.","IW654384JJGF","FLORAL CASE","Apple","iphone 13 Pro max","Quantity: 1","Cancelled","Bought 1 product","Total: 320000",150000, R.drawable.case1, R.drawable.ic_baseline_shopping_bag_24)); myOrder.add(new MyOrder("Track no.","IW654384JJGF","FLORAL CASE","Apple","iphone 13 Pro max","Quantity: 1","Cancelled","Bought 1 product","Total: 320000",150000, R.drawable.case1, R.drawable.ic_baseline_shopping_bag_24));


        myOrdersAdapter = new MyOrdersAdapter(this.getActivity(), R.layout.orderitem,myOrder,this);
        rcvProduct.setAdapter(myOrdersAdapter);
        return view;
    }
    private void replaceFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment).addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onItemClick(MyOrder myOrder) {
        replaceFragment(new Cancelled_OrderDetails());
    }

    @Override
    public void onDetailClick(MyOrder myOrder) {
        replaceFragment(new Cancelled_OrderDetails());
    }

    @Override
    public void onReOrderClick(MyOrder myOrder) {
        Intent intent = new Intent(getActivity(),CheckoutActivity.class);
        startActivity(intent);

    }
}