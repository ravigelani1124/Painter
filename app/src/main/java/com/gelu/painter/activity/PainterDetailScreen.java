package com.gelu.painter.activity;

import android.os.Bundle;

import com.gelu.painter.R;
import com.gelu.painter.adapter.PainterPersonalDetailsAdapter;
import com.gelu.painter.adapter.ViewPagerAdapter;
import com.gelu.painter.model.PainterImages;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

public class PainterDetailScreen extends AppCompatActivity implements PainterPersonalDetailsAdapter.OnLikeClick, ViewPagerAdapter.OnLikeClick {

    private PainterDetailScreen mContext;
    private RecyclerView rvPainterInfo;
    private PainterPersonalDetailsAdapter detailsAdapter;
    private ArrayList<PainterImages> painterImagesArrayList;
    ViewPagerAdapter viewPagerAdapter;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_painter_detail_screen);
        mContext = this;
        initUI();
    }

    private void initUI() {
        painterImagesArrayList = new ArrayList<>();
        for (int j = 1; j <= 10; j++) {
            PainterImages painterImages = new PainterImages();
            painterImages.setId(j);
            painterImages.setLike(false);
            painterImages.setLikeCount(0);
            if (j == 1) {
                painterImages.setImages(ContextCompat.getDrawable(mContext, R.drawable.a1));
            } else if (j == 2) {
                painterImages.setImages(ContextCompat.getDrawable(mContext, R.drawable.a2));
            } else if (j == 3) {
                painterImages.setImages(ContextCompat.getDrawable(mContext, R.drawable.a3));
            } else if (j == 4) {
                painterImages.setImages(ContextCompat.getDrawable(mContext, R.drawable.a4));
            } else if (j == 5) {
                painterImages.setImages(ContextCompat.getDrawable(mContext, R.drawable.a5));
            } else if (j == 6) {
                painterImages.setImages(ContextCompat.getDrawable(mContext, R.drawable.a6));
            } else if (j == 7) {
                painterImages.setImages(ContextCompat.getDrawable(mContext, R.drawable.a7));
            } else if (j == 8) {
                painterImages.setImages(ContextCompat.getDrawable(mContext, R.drawable.a8));
            } else if (j == 9) {
                painterImages.setImages(ContextCompat.getDrawable(mContext, R.drawable.a9));
            } else {
                painterImages.setImages(ContextCompat.getDrawable(mContext, R.drawable.a10));
            }
            painterImagesArrayList.add(painterImages);
        }
/*
        rvPainterInfo = findViewById(R.id.rvPainterImagesDetails);
        rvPainterInfo.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvPainterInfo.setAdapter(detailsAdapter);
        */
        viewPager = findViewById(R.id.viewPager);
        detailsAdapter = new PainterPersonalDetailsAdapter(mContext, painterImagesArrayList, this);
        viewPagerAdapter = new ViewPagerAdapter(mContext, painterImagesArrayList, this);
        viewPager.setAdapter(viewPagerAdapter);
    }

    @Override
    public void onLikeClick(PainterImages painterImages, int position, AppCompatImageView ivLike) {

        if (painterImagesArrayList.get(position).getLike()) {
            painterImagesArrayList.get(position).setLike(false);
        } else {
            painterImagesArrayList.get(position).setLike(true);
        }
        viewPagerAdapter.notifyDataSetChanged();

    }

  /*  @Override
    public void onLikeClick(PainterImages painterImages, int position, AppCompatImageView ivLike) {

        boolean isLike = false;
        if (isLike) {
            isLike = true;
            ivLike.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.like));
        } else {
            isLike = false;
            ivLike.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.dislike));
        }
    }*/
}
