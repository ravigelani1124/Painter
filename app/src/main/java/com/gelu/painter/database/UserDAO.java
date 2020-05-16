package com.gelu.painter.database;

import com.gelu.painter.utility.Constant;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDAO {

    @Insert
    void addUser(User user);

    @Query("select * from " + Constant.TABLE_USER)
    List<User> getAllUser();
}
