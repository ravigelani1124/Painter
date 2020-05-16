package com.gelu.painter.database;

import com.gelu.painter.model.PainterImages;
import com.gelu.painter.utility.Constant;

import java.util.ArrayList;
import java.util.List;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

@Entity(tableName = Constant.TABLE_PAINTER)
public class Painter {

    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "PainterName")
    String PainterName;

    @ColumnInfo(name = "PainterImageList")
    @TypeConverters({Converters.class})
    List<PainterImages> painterImagesArrayList;

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
        /*if (painterImagesArrayList == null) {
            painterImagesArrayList = new ArrayList<>();
            return painterImagesArrayList;
        }*/
        return painterImagesArrayList;
    }

    public void setPainterImagesArrayList(List<PainterImages> painterImagesArrayList) {
        this.painterImagesArrayList = painterImagesArrayList;
    }
}
