package com.example.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.doannhom7.R;
import com.example.model.Product;

import java.util.ArrayList;
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
            holder.txtProduct=convertView.findViewById(R.id.txtProductPrice);
            holder.txtProductPrice=convertView.findViewById(R.id.txtProductPrice);
            convertView.setTag(holder);
        }
        else
        {
            holder=(ViewHolder) convertView.getTag();
        }
        Product p = ProductList.get(position);
        holder.imvProduct.setImageResource(p.getProductThumb());
        holder.txtProduct.setText(p.getProductName());
        holder.txtProductPrice.setText(String.valueOf(p.getProductPrice()));
        return convertView;
    }

    private class ViewHolder {
        ImageView imvProduct;
        TextView txtProduct, txtProductPrice;
    }
}
