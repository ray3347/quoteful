package com.example.quoteful;

import android.app.Application;

import androidx.room.Room;

import com.example.quoteful.services.database.LocalDB;

public class Quoteful extends Application {
    public static LocalDB db;
    @Override
    public void onCreate() {
        super.onCreate();
        db = Room.databaseBuilder(getApplicationContext(), LocalDB.class, "quotefulLocalDB")
                .allowMainThreadQueries()
                .build();
    }
}
