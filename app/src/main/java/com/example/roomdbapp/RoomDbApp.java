package com.example.roomdbapp;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.example.roomdbapp.DataBase.AppDatabase;

public class RoomDbApp extends Application {

    private AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();

        database = Room.databaseBuilder(this, AppDatabase.class, "mydb")
                .allowMainThreadQueries()
                .build();
    }

    public AppDatabase getDatabase() {
        return database;
    }

}
