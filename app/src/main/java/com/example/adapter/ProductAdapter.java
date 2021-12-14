package com.example.adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.drawermenuex.ProductDetailsFragment;
import com.example.model.Product;
import com.example.drawermenuex.R;
import com.example.util.Constant;

import java.util.List;

public class ProductAdapter extends BaseAdapter {
    Activity context;
    int item_product;
    List<Product> ProductList;

    public ProductAdapter(Activity context, int item_product, List<Product> productList) {
        this.context = context;
        this.item_product = item_product;
        ProductList = productList;
    }

    @Override
    public int getCount() {
        return ProductList.size();
    }

    @Override
    public Object getItem(int position) {
        return ProductList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null)
        {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(item_product,null);
            holder.imvProduct=convertView.findViewById(R.id.imvProduct);
            holder.txtProduct=convertView.findViewById(R.id.txtProduct);
            holder.txtProductPrice=convertView.findViewById(R.id.txtProductPrice);
            holder.ratingBar=convertView.findViewById(R.id.Rating_bar_products);
            holder.txtProductRatingNumber=convertView.findViewById(R.id.txtRatingNumber);
            holder.item_products=convertView.findViewById(R.id.item_products);
            convertView.setTag(holder);
        }
        else
        {
            holder=(ViewHolder) convertView.getTag();
        }
        Product p = ProductList.get(position);
        //Load hình từ firebase lên imageview bằng cách sử dụng thư viện ngoài
        Glide.with(context).load(p.getProductThumb()).into(holder.imvProduct);
//        holder.imvProduct.setImageResource(p.getProductThumb());
        holder.txtProduct.setText(p.getProductName());
        holder.txtProductPrice.setText(String.valueOf(p.getProductPrice()));
        holder.ratingBar.setRating(p.getProductRating());
        holder.txtProductRatingNumber.setText(p.getProductRatingNumber());
        holder.item_products.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                ProductDetailsFragment fragment=new ProductDetailsFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,fragment).addToBackStack(null).commit();;
                Bundle bundle = new Bundle();
                bundle.putSerializable(Constant.SELECTED_ITEM,p);
                fragment.setArguments(bundle);
            }
        });
        return convertView;
    }

    private class ViewHolder {
        LinearLayout item_products;
        ImageView imvProduct;
        TextView txtProduct, txtProductPrice,txtProductRatingNumber;
        RatingBar ratingBar;
    }
}
