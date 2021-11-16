package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.AboutUs;
import com.example.doannhom7.R;

import java.util.ArrayList;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.ViewHolder> {
    Context context;
    ArrayList<AboutUs> banner;

    public BannerAdapter(Context context, ArrayList<AboutUs> banner) {
        this.context = context;
        this.banner = banner;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_about_us,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AboutUs ab = banner.get(position);
        holder.imvBanner.setImageResource(banner.get(position).getBanner());
    }

    @Override
    public int getItemCount() {
        return banner.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imvBanner;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imvBanner = itemView.findViewById(R.id.imvBanner);

        }
    }
}
