package com.example.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doannhom7.R;
import com.example.model.MyOrder;

import java.util.List;


public class MyOrdersAdapter extends RecyclerView.Adapter<MyOrdersAdapter.ViewHolder>{

    Activity context;
    int orderitem;
    List<MyOrder> myOrdersList;

    public MyOrdersAdapter(Activity context, int orderitem, List<MyOrder> myOrdersList) {
        this.context = context;
        this.orderitem = orderitem;
        this.myOrdersList = myOrdersList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.orderitem,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MyOrder d =myOrdersList.get(position);
        holder.imvcase.setImageResource(d.getImvcase());
        holder.txtPrice.setText(String.valueOf(d.getTxtPrice()));
        holder.txttrack.setText(d.getTxttrack());
        holder.txttrackNumber.setText(d.getTxttrackNumber());
        holder.txtName.setText(d.getTxtName());
        holder.txtStatus.setText(d.getTxtStatus());
        holder.txtType.setText(d.getTxtType());
        holder.txtQuantity.setText(d.getTxtQuantity());
        holder.txtTotal.setText(d.getTxtTotal());
        holder.txtBought.setText(d.getTxtBought());
        holder.txtApple.setText(d.getTxtApple());
    }

    @Override
    public int getItemCount() {
        return myOrdersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imvcase,imvbag;
        TextView txtName, txtTotal,txttrack,txttrackNumber,txtApple,txtType,txtQuantity,txtStatus,txtBought,txtPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imvcase=itemView.findViewById(R.id.imvcase);
            imvbag=itemView.findViewById(R.id.imvbag);
            txtName=itemView.findViewById(R.id.txtName);
            txtTotal=itemView.findViewById(R.id.txtTotal);
            txttrack=itemView.findViewById(R.id.txttrack);
            txttrackNumber=itemView.findViewById(R.id.txttrackNumber);
            txtApple=itemView.findViewById(R.id.txtApple);
            txtType=itemView.findViewById(R.id.txtType);
            txtQuantity=itemView.findViewById(R.id.txtQuantity);
            txtStatus=itemView.findViewById(R.id.txtStatus);
            txtBought=itemView.findViewById(R.id.txtBought);
            txtPrice=itemView.findViewById(R.id.txtPrice);

        }
    }

}
