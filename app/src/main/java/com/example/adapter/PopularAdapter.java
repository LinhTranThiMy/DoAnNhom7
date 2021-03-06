package com.example.adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.drawermenuex.ProductDetailsFragment;
import com.example.model.Popular;
import com.example.drawermenuex.R;
import com.example.model.Product;
import com.example.util.Constant;

import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {
    Activity context;
    ArrayList<Product> populars;

    public PopularAdapter(Activity context, ArrayList<Product> populars) {
        this.context = context;
        this.populars = populars;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_popular,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product popular = populars.get(position);
        //Load hình từ firebase lên imageview bằng cách sử dụng thư viện ngoài
        Glide.with(context).load(popular.getProductThumb()).into(holder.imvPopular);
//        holder.imvPopular.setImageResource(populars.get(position).getProductThumb());
        holder.txtName.setText(popular.getProductName());
        holder.txtPrice.setText(String.valueOf(popular.getProductPrice()));
        holder.item_populars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                ProductDetailsFragment fragment=new ProductDetailsFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,fragment).addToBackStack(null).commit();;
                Bundle bundle = new Bundle();
                bundle.putSerializable(Constant.SELECTED_ITEM,popular);
                fragment.setArguments(bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return populars.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout item_populars;
        ImageView imvPopular;
        TextView txtName, txtPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imvPopular = itemView.findViewById(R.id.imvPopular);
            txtName = itemView.findViewById(R.id.txtName);
            txtPrice=itemView.findViewById(R.id.txtPrice);
            item_populars=itemView.findViewById(R.id.item_populars);

        }
    }
}
