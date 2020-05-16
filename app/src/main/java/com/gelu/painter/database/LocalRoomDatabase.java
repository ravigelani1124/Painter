package com.gelu.painter.database;

import android.content.Context;

import com.gelu.painter.utility.Constant;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;


@Database(entities = {User.class, Painter.class}, exportSchema = false, version = 2)
//@TypeConverters({Converters.class})
public abstract class LocalRoomDatabase extends RoomDatabase {
    private static LocalRoomDatabase instance;

    public static synchronized LocalRoomDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), LocalRoomDatabase.class, Constant.DB_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    public abstract UserDAO userDAO();
    public abstract PainterDao painterDao();
}
