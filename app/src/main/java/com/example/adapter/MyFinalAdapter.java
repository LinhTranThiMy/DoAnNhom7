package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.drawermenuex.R;
import com.example.eventbus.MyUpdateCartEvent;
import com.example.model.CartModel;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MyFinalAdapter extends RecyclerView.Adapter<MyFinalAdapter.MyFinalViewHolder> {
    private Context context;
    private List<CartModel> cartModelList;

    public MyFinalAdapter(Context context, List<CartModel> cartModelList) {
        this.context = context;
        this.cartModelList = cartModelList;
    }

    @NonNull
    @Override
    public MyFinalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyFinalViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.item_final, parent, false));
    }

    //BindView
    public class MyFinalViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imageView)
        ImageView imageView;
        @BindView(R.id.txtName)
        TextView txtName;
        @BindView(R.id.txtType)
        TextView txtType;
        @BindView(R.id.txtPrice)
        TextView txtPrice;
        @BindView(R.id.txtQuantity)
        TextView txtQuantity;

        Unbinder unbinder;

        public MyFinalViewHolder(@NonNull View itemView) {
            super(itemView);
            unbinder = ButterKnife.bind(this, itemView);
        }

    }
    @Override
    public void onBindViewHolder(@NonNull MyFinalViewHolder holder, int position) {

        CartModel pd = cartModelList.get(position);
        Glide.with(context).load(pd.getImage()).into(holder.imageView);
        holder.txtPrice.setText(new StringBuilder().append(pd.getPrice()));
        holder.txtName.setText(new StringBuilder().append(pd.getName()));
        holder.txtQuantity.setText(new StringBuilder().append(pd.getQuantity()));

    }



    @Override
    public int getItemCount() {return cartModelList.size(); }

}
