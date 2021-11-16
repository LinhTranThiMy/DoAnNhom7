package com.example.doannhom7;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.adapter.MyOrdersAdapter;
import com.example.model.MyOrder;

import java.util.ArrayList;


public class Processing_MyOrders extends Fragment {
    RecyclerView rcvProduct;
    MyOrdersAdapter myOrdersAdapter;
    ArrayList<MyOrder> myOrder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_cancelled__my_orders, container, false);
        rcvProduct =view.findViewById(R.id.rcvProduct);

        LinearLayoutManager manager= new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        rcvProduct.setLayoutManager(manager);


        myOrder = new ArrayList<>();
        myOrder.add(new MyOrder("Track no.","IW654384JJGF","FLORAL CASE","Apple","iphone 13 Pro max","Quantity: 1","Completed","Bought 1 product","Total: 320000",150000,R.drawable.case1,R.drawable.ic_baseline_shopping_bag_24)); myOrder.add(new MyOrder("Track no.","IW654384JJGF","FLORAL CASE","Apple","iphone 13 Pro max","Quantity: 1","Completed","Bought 1 product","Total: 320000",150000,R.drawable.case1,R.drawable.ic_baseline_shopping_bag_24)); myOrder.add(new MyOrder("Track no.","IW654384JJGF","FLORAL CASE","Apple","iphone 13 Pro max","Quantity: 1","Completed","Bought 1 product","Total: 320000",150000,R.drawable.case1,R.drawable.ic_baseline_shopping_bag_24)); myOrder.add(new MyOrder("Track no.","IW654384JJGF","FLORAL CASE","Apple","iphone 13 Pro max","Quantity: 1","Completed","Bought 1 product","Total: 320000",150000,R.drawable.case1,R.drawable.ic_baseline_shopping_bag_24)); myOrder.add(new MyOrder("Track no.","IW654384JJGF","FLORAL CASE","Apple","iphone 13 Pro max","Quantity: 1","Completed","Bought 1 product","Total: 320000",150000,R.drawable.case1,R.drawable.ic_baseline_shopping_bag_24));


        myOrdersAdapter = new MyOrdersAdapter(this.getActivity(),R.layout.orderitem,myOrder);
        rcvProduct.setAdapter(myOrdersAdapter);
        return view;
    }
}