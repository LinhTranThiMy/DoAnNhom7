package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.drawermenuex.R;
import com.example.model.ProductDetailsBanner;

import java.util.ArrayList;

public class ProductDetailsAdapter extends RecyclerView.Adapter<ProductDetailsAdapter.ViewHolder> {

    Context context;
    ArrayList<ProductDetailsBanner> productDetails;

    public ProductDetailsAdapter(Context context, ArrayList<ProductDetailsBanner> productDetails) {
        this.context = context;
        this.productDetails = productDetails;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_product_details,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductDetailsBanner pd = productDetails.get(position);
        Glide.with(context).load(pd.getProductDetailsBanner()).into(holder.imvProductDetails);
//        holder.imvProductDetails.setImageResource(pd.getProductDetailsBanner());
    }

    @Override
    public int getItemCount() {
        return productDetails.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imvProductDetails;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imvProductDetails = itemView.findViewById(R.id.imvProductDetails);

        }
    }
}
