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

public class MyCartAdapter extends RecyclerView.Adapter<MyCartAdapter.MyCartViewHolder> {
    private Context context;
    private List<CartModel> cartModelList;

    public MyCartAdapter(Context context, List<CartModel> cartModelList) {
        this.context = context;
        this.cartModelList = cartModelList;
    }

    @NonNull
    @Override
    public MyCartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyCartViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.item_cart, parent, false));
    }

    //BindView
    public class MyCartViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.btnMinus)
        ImageView btnMinus;
        @BindView(R.id.btnPlus)
        ImageView btnPlus;
        @BindView(R.id.btnDelete)
        ImageView btnDelete;
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

        public MyCartViewHolder(@NonNull View itemView) {
            super(itemView);
            unbinder = ButterKnife.bind(this, itemView);
        }

    }
    @Override
    public void onBindViewHolder(@NonNull MyCartViewHolder holder, int position) {

        CartModel pd = cartModelList.get(position);
        Glide.with(context).load(pd.getImage()).into(holder.imageView);
        holder.txtPrice.setText(new StringBuilder().append(pd.getPrice()));
        holder.txtName.setText(new StringBuilder().append(pd.getName()));
        holder.txtQuantity.setText(new StringBuilder().append(pd.getQuantity()));

        //Event
        holder.btnPlus.setOnClickListener(v -> {
            plusCartItem(holder, cartModelList.get(position));
        });
        holder.btnMinus.setOnClickListener(v -> {
            minusCartItem(holder, cartModelList.get(position));
        });
        holder.btnDelete.setOnClickListener(v -> {
            AlertDialog dialog = new AlertDialog.Builder(context)
                    .setTitle("Delete item?")
                    .setMessage("Do you really want to delete item?")
                    .setNegativeButton("CANCEL", (dialog1, which) -> dialog1.dismiss())
                    .setPositiveButton("OK", (dialog12, which) -> {

                        //Temp remove:
                        notifyItemRemoved(position);

                        deleteFromFirebase(cartModelList.get(position));
                        dialog12.dismiss();
                    }).create();
            dialog.show();
        });


    }

    private void deleteFromFirebase(CartModel cartModel) {
        //Copy t??? updateFromFirebase
        FirebaseDatabase.getInstance()
                .getReference("Cart")
                .child("UNIQUE_USER_ID")
                .child(cartModel.getKey())
                .removeValue()
                .addOnSuccessListener(aVoid -> EventBus.getDefault().postSticky(new MyUpdateCartEvent()));
    }

    private void minusCartItem(MyCartViewHolder holder, CartModel cartModel) {
        if(cartModel.getQuantity() >1)
        {
            cartModel.setQuantity(cartModel.getQuantity()-1);
            cartModel.setTotalPrice(cartModel.getQuantity()*Float.parseFloat(cartModel.getPrice()));

            //Update quantity
            holder.txtQuantity.setText(new StringBuilder().append(cartModel.getQuantity()));
            updateFirebase(cartModel);
        }
    }

    private void plusCartItem(MyCartViewHolder holder, CartModel cartModel) {
        cartModel.setQuantity(cartModel.getQuantity() +1);
        cartModel.setTotalPrice(cartModel.getQuantity()*Float.parseFloat(cartModel.getPrice()));

        //Update quantity
        holder.txtQuantity.setText(new StringBuilder().append(cartModel.getQuantity()));
        updateFirebase(cartModel);
    }


    private void updateFirebase(CartModel cartModel) {
        FirebaseDatabase.getInstance()
                .getReference("Cart")
                .child("UNIQUE_USER_ID")
                .child(cartModel.getKey())
                .setValue(cartModel)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        EventBus.getDefault().postSticky(new MyUpdateCartEvent());
                    }
                });
    }


    @Override
    public int getItemCount() {return cartModelList.size(); }

}
