package com.example.dailychef.DB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "userLogin")
    public String userLogin;

    @ColumnInfo(name = "displayName")
    public String displayName;

    @ColumnInfo(name = "email")
    public String email;

    @ColumnInfo(name = "password")
    public String password;

    public User(String userLogin, String displayName, String email, String password) {
        this.userLogin = userLogin;
        this.displayName = displayName;
        this.email = email;
        this.password = password;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
