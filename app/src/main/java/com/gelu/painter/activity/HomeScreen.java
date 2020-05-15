package com.gelu.painter.activity;

import android.content.Intent;
import android.os.Bundle;

import com.gelu.painter.R;
import com.gelu.painter.adapter.PainterAdapter;
import com.gelu.painter.model.Painter;
import com.gelu.painter.model.PainterImages;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HomeScreen extends AppCompatActivity implements PainterAdapter.OnInfoClick {

    private HomeScreen mContext;
    private RecyclerView rvPainter;
    private ArrayList<Painter> painterArrayList;
    private ArrayList<PainterImages> painterImagesArrayList;
    private PainterAdapter painterAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        initUi();
    }

    private void initUi() {
        painterArrayList = new ArrayList<>();
        painterImagesArrayList = new ArrayList<>();
        rvPainter = findViewById(R.id.rvPainter);
        rvPainter.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        painterAdapter = new PainterAdapter(mContext, painterArrayList, this);
        rvPainter.setAdapter(painterAdapter);
        //setData for painter
        setPainterData();
    }

    private void setPainterData() {
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

        for (int i = 1; i <= 10; i++) {
            Painter painter = new Painter();
            painter.setId(i);
            painter.setmPainterName("Painter " + i);
            painter.setPainterImagesArrayList(painterImagesArrayList);
            painterArrayList.add(painter);
        }
        painterAdapter.notifyDataSetChanged();
    }

    @Override
    public void painterInfo(Painter painter, int position) {
        startActivity(new Intent(mContext, PainterDetailScreen.class).putExtra("painterData", painter.getId()));
    }
}
