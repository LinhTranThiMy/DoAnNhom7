package com.example.adapter;

import android.app.Activity;
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
import com.example.drawermenuex.R;
import com.example.model.Product;
import com.example.util.Constant;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {
    Activity context;
    ArrayList<Product> search;

    public SearchAdapter(Activity context, ArrayList<Product> search) {
        this.context = context;
        this.search = search;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_search,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product ps = search.get(position);
        //Load hình từ firebase lên imageview bằng cách sử dụng thư viện ngoài
        Glide.with(context).load(ps.getProductThumb()).into(holder.imvSearch);
//        holder.imvPopular.setImageResource(populars.get(position).getProductThumb());
        holder.txtNameSearch.setText(ps.getProductName());
        holder.txtPriceSearch.setText(String.valueOf(ps.getProductPrice()));
        holder.item_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                ProductDetailsFragment fragment=new ProductDetailsFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,fragment).addToBackStack(null).commit();;
                Bundle bundle = new Bundle();
                bundle.putSerializable(Constant.SELECTED_ITEM,ps);
                fragment.setArguments(bundle);
            }
        });

    }

    @Override
    public int getItemCount() {
        return search.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout item_search;
        ImageView imvSearch;
        TextView txtNameSearch, txtPriceSearch;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imvSearch=itemView.findViewById(R.id.imvSearch);
            txtNameSearch=itemView.findViewById(R.id.txtNameSearch);
            txtPriceSearch=itemView.findViewById(R.id.txtPriceSearch);
            item_search=itemView.findViewById(R.id.item_Search);

        }
    }
    public void Search (ArrayList<Product> searchList)
    {
        search=searchList;
        notifyDataSetChanged();
    }
}
