package com.example.dailychef.DB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, Receita.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract ReceitaDao receitaDao();

    private static AppDatabase instance;



    public static AppDatabase getDbInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context, AppDatabase.class, "Dailychef").allowMainThreadQueries().build();
        }
        return instance;
    }
}