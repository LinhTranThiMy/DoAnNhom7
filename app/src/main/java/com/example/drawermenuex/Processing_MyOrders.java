package com.example.drawermenuex;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adapter.MyOrdersProcessAdapter;
import com.example.interfaces.ItemClickListener;
import com.example.model.MyOrder;

import java.util.ArrayList;


public class Processing_MyOrders extends Fragment implements ItemClickListener {
    RecyclerView rcvProduct;
    MyOrdersProcessAdapter myOrdersProcessAdapter;
    ArrayList<MyOrder> myOrder;

    private ItemClickListener clickListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
     View view= inflater.inflate(R.layout.fragment_processing__my_orders, container, false);
        rcvProduct =view.findViewById(R.id.rcvProduct);


        LinearLayoutManager manager= new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        rcvProduct.setLayoutManager(manager);


        myOrder = new ArrayList<>();
        myOrder.add(new MyOrder("Track no.","IW654384JJGF","FLORAL CASE","Apple","iphone 13 Pro max","Quantity: 1","Processing","Bought 1 product","Total: 320000",150000, R.drawable.case1, R.drawable.ic_baseline_shopping_bag_24)); myOrder.add(new MyOrder("Track no.","IW654384JJGF","FLORAL CASE","Apple","iphone 13 Pro max","Quantity: 1","Processing","Bought 1 product","Total: 320000",150000, R.drawable.case1, R.drawable.ic_baseline_shopping_bag_24)); myOrder.add(new MyOrder("Track no.","IW654384JJGF","FLORAL CASE","Apple","iphone 13 Pro max","Quantity: 1","Processing","Bought 1 product","Total: 320000",150000, R.drawable.case1, R.drawable.ic_baseline_shopping_bag_24)); myOrder.add(new MyOrder("Track no.","IW654384JJGF","FLORAL CASE","Apple","iphone 13 Pro max","Quantity: 1","Completed","Bought 1 product","Total: 320000",150000, R.drawable.case1, R.drawable.ic_baseline_shopping_bag_24)); myOrder.add(new MyOrder("Track no.","IW654384JJGF","FLORAL CASE","Apple","iphone 13 Pro max","Quantity: 1","Processing","Bought 1 product","Total: 320000",150000, R.drawable.case1, R.drawable.ic_baseline_shopping_bag_24));


        myOrdersProcessAdapter = new MyOrdersProcessAdapter(this.getActivity(), R.layout.orderitem_process,myOrder,this);
        rcvProduct.setAdapter(myOrdersProcessAdapter);
        return view;
    }
    private void replaceFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment).addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onItemClick(MyOrder myOrder) {
        replaceFragment(new Processing_OrderDetails());
    }

    @Override
    public void onDetailClick(MyOrder myOrder) {
        replaceFragment(new Processing_OrderDetails());
    }

    @Override
    public void onReOrderClick(MyOrder myOrder) {
        //fragment reorder
    }
}