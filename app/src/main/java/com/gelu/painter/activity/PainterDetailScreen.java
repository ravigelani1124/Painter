package com.gelu.painter.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.gelu.painter.R;
import com.gelu.painter.adapter.PainterPersonalDetailsAdapter;
import com.gelu.painter.adapter.ViewPagerAdapter;
import com.gelu.painter.model.PainterImages;
import com.gelu.painter.utility.TinyDB;
import java.util.ArrayList;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

public class PainterDetailScreen extends AppCompatActivity implements PainterPersonalDetailsAdapter.OnLikeClick, ViewPagerAdapter.OnLikeClick, View.OnClickListener {

    private PainterDetailScreen mContext;
    private PainterPersonalDetailsAdapter detailsAdapter;
    private ArrayList<PainterImages> painterImagesArrayList;
    private ViewPagerAdapter viewPagerAdapter;
    private ViewPager viewPager;
    private AppCompatImageView ivLogout;

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

        viewPager = findViewById(R.id.viewPager);
        detailsAdapter = new PainterPersonalDetailsAdapter(mContext, painterImagesArrayList, this);
        viewPagerAdapter = new ViewPagerAdapter(mContext, painterImagesArrayList, this);
        viewPager.setAdapter(viewPagerAdapter);
        ivLogout = findViewById(R.id.ivLogout);
        ivLogout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ivLogout:
                new TinyDB(mContext).clear();
                startActivity(new Intent(mContext, LoginScreen.class));
                finishAffinity();
                break;
        }
    }

    @Override
    public void onLikeClick(PainterImages painterImages, int position, AppCompatImageView ivLike, TextView tvLike) {
        if (painterImagesArrayList.get(position).getLike()) {
            tvLike.setText("0");
            painterImagesArrayList.get(position).setLikeCount(0);
            painterImagesArrayList.get(position).setLike(false);
        } else {
            tvLike.setText("1");
            painterImagesArrayList.get(position).setLikeCount(1);
            painterImagesArrayList.get(position).setLike(true);
        }
        viewPagerAdapter.notifyDataSetChanged();
    }
}



