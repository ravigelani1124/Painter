package com.gelu.painter.database;

import com.gelu.painter.utility.Constant;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface PainterDao {

    @Insert
    void addPainter(Painter painter);

    @Query("select * from " + Constant.TABLE_PAINTER)
    List<Painter> getAllPainter();


}
