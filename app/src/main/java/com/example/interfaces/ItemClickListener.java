package com.example.interfaces;

import com.example.model.MyOrder;

public interface ItemClickListener {
    public void onItemClick(MyOrder myOrder);
    public void onDetailClick(MyOrder myOrder);
    public void onReOrderClick(MyOrder myOrder);



}
