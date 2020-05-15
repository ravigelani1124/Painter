package com.gelu.painter.model;

import java.util.ArrayList;

public class Painter {

    private int id;
    private String mPainterName;
    private ArrayList<PainterImages> painterImagesArrayList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getmPainterName() {
        return mPainterName;
    }

    public void setmPainterName(String mPainterName) {
        this.mPainterName = mPainterName;
    }

    public ArrayList<PainterImages> getPainterImagesArrayList() {
        return painterImagesArrayList;
    }

    public void setPainterImagesArrayList(ArrayList<PainterImages> painterImagesArrayList) {
        this.painterImagesArrayList = painterImagesArrayList;
    }
}
