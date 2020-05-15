package com.gelu.painter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gelu.painter.R;
import com.gelu.painter.model.PainterImages;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<PainterImages> painterImagesArrayList;

    public ImageAdapter(Context context, ArrayList<PainterImages> painterImagesArrayList) {
        this.context = context;
        this.painterImagesArrayList = painterImagesArrayList;
    }

    @NonNull
    @Override
    public ImageAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_images, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdapter.MyViewHolder holder, int position) {
        PainterImages painterImages = painterImagesArrayList.get(position);
        holder.ivPaint.setImageDrawable(painterImages.getImages());
    }

    @Override
    public int getItemCount() {
        return painterImagesArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        AppCompatImageView ivPaint;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPaint = itemView.findViewById(R.id.ivPaint);
        }
    }
}
