package com.gelu.painter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gelu.painter.R;
import com.gelu.painter.model.PainterImages;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class PainterPersonalDetailsAdapter extends RecyclerView.Adapter<PainterPersonalDetailsAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<PainterImages> painterImagesArrayList;
    private OnLikeClick onLikeClick;


    public PainterPersonalDetailsAdapter(Context context, ArrayList<PainterImages> painterImagesArrayList,OnLikeClick onLikeClick) {
        this.context = context;
        this.painterImagesArrayList = painterImagesArrayList;
        this.onLikeClick=onLikeClick;
    }

    @NonNull
    @Override
    public PainterPersonalDetailsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_image_details, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final PainterPersonalDetailsAdapter.MyViewHolder holder, final int position) {
        final PainterImages painterImages = painterImagesArrayList.get(position);
        holder.ivImages.setImageDrawable(painterImages.getImages());

        if (painterImages.getLike() != null) {
            if (painterImages.getLike()) {
                holder.tvLikeCount.setText(String.valueOf(1));
                holder.ivLike.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.like));
            } else {
                holder.tvLikeCount.setText(String.valueOf(painterImages.getLikeCount()));
                holder.ivLike.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.dislike));
                holder.tvLikeCount.setText(String.valueOf(0));
            }
        } else {
            holder.ivLike.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.dislike));
            holder.tvLikeCount.setText(String.valueOf(0));
        }

        holder.tvLikeCount.setText(String.valueOf(painterImages.getLikeCount()));
        holder.ivLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onLikeClick.onLikeClick(painterImages,position,holder.ivLike,holder.tvLikeCount);
            }
        });

    }

    @Override
    public int getItemCount() {
        return painterImagesArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        AppCompatImageView ivImages, ivLike;
        TextView tvLikeCount;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ivLike = itemView.findViewById(R.id.ivLike);
            ivImages = itemView.findViewById(R.id.ivPaint);
            tvLikeCount = itemView.findViewById(R.id.tvLikeCount);
        }
    }

   public interface OnLikeClick{
        void onLikeClick(PainterImages painterImages,int position,AppCompatImageView ivLike,TextView tvLike);
    }
}
