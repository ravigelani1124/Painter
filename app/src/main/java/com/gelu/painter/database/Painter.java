package com.gelu.painter.database;

import com.gelu.painter.model.PainterImages;

import java.util.List;


public class Painter {

    private int id;
    private String PainterName;
    private List<PainterImages> painterImagesArrayList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPainterName() {
        return PainterName;
    }

    public void setPainterName(String painterName) {
        PainterName = painterName;
    }

    public List<PainterImages> getPainterImagesArrayList() {
        return painterImagesArrayList;
    }

    public void setPainterImagesArrayList(List<PainterImages> painterImagesArrayList) {
        this.painterImagesArrayList = painterImagesArrayList;
    }
}
