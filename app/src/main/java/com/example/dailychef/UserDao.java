package com.example.dailychef;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getUsers();

    @Query("SELECT * FROM user WHERE userLogin LIKE :userLogin")
    User findByUserLogin(String userLogin);

    @Query("SELECT * FROM user WHERE userLogin LIKE :userLogin AND password LIKE :psw")
    User login(String userLogin, String psw);

    @Insert
    void insert(User... users);
}
