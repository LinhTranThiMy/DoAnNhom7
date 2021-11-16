package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.Popular;
import com.example.doannhom7.R;

import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {
    Context context;
    ArrayList<Popular> populars;

    public PopularAdapter(Context context, ArrayList<Popular> populars) {
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
        Popular popular = populars.get(position);
        holder.imvPopular.setImageResource(populars.get(position).getProductPopular());
        holder.txtName.setText(populars.get(position).getProductNamePopular());
        holder.txtPrice.setText(String.valueOf(populars.get(position).getProductPricePopular()));
    }

    @Override
    public int getItemCount() {
        return populars.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imvPopular;
        TextView txtName, txtPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imvPopular = itemView.findViewById(R.id.imvPopular);
            txtName = itemView.findViewById(R.id.txtName);
            txtPrice=itemView.findViewById(R.id.txtPrice);

        }
    }
}
