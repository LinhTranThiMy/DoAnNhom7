package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doannhom7.R;
import com.example.model.Slider;

import java.util.ArrayList;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.ViewHolder> {
    Context context;
    ArrayList<Slider> sliders;

    public SliderAdapter(Context context, ArrayList<Slider> sliders) {
        this.context = context;
        this.sliders = sliders;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View view= inflater.inflate(R.layout.slider,parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Slider slider= sliders.get(position);
        holder.imvSlider.setImageResource(sliders.get(position).getSlider());

    }

    @Override
    public int getItemCount() {
        return sliders.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imvSlider;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imvSlider = itemView.findViewById(R.id.imvSlider);

        }
    }
}
