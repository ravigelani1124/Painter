package com.gelu.painter.database;

import com.gelu.painter.utility.Constant;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = Constant.TABLE_USER)
public class User {

    @PrimaryKey(autoGenerate = true)
    int sr_no;

    @ColumnInfo(name = "id")
    int id;

    @ColumnInfo(name = "userId")
    String userId;

    @ColumnInfo(name = "userPassword")
    String password;

    public int getSr_no() {
        return sr_no;
    }

    public void setSr_no(int sr_no) {
        this.sr_no = sr_no;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
