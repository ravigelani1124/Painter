package com.gelu.painter.database;

import com.gelu.painter.model.PainterImages;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import androidx.room.TypeConverter;

public class Converters {

    @TypeConverter
    public static List<PainterImages> fromString(String value) {
        Type listType = new TypeToken<List<PainterImages>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromArrayLisr(List<PainterImages> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

}
