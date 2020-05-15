package com.gelu.painter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gelu.painter.R;
import com.gelu.painter.model.Painter;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PainterAdapter extends RecyclerView.Adapter<PainterAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<Painter> painterArrayList;
    private OnInfoClick onInfoClick;

    public PainterAdapter(Context context, ArrayList<Painter> painterArrayList, OnInfoClick onInfoClick) {
        this.context = context;
        this.painterArrayList = painterArrayList;
        this.onInfoClick = onInfoClick;
    }

    @NonNull
    @Override
    public PainterAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_painter, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PainterAdapter.MyViewHolder holder, final int position) {
        final Painter painter = painterArrayList.get(position);
        holder.tvPainterName.setText(painter.getmPainterName());

        ImageAdapter imageAdapter = new ImageAdapter(context, painter.getPainterImagesArrayList());
        holder.rvPainterImages.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.rvPainterImages.setAdapter(imageAdapter);
        holder.ivInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onInfoClick.painterInfo(painter, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return painterArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvPainterName;
        RecyclerView rvPainterImages;
        AppCompatImageView ivInfo;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPainterName = itemView.findViewById(R.id.tvPainterName);
            rvPainterImages = itemView.findViewById(R.id.rvPainterImages);
            ivInfo = itemView.findViewById(R.id.ivInfo);
        }
    }

   public interface OnInfoClick {
        void painterInfo(Painter painter, int position);
    }
}
