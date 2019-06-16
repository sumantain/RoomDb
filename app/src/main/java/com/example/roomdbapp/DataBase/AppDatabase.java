package com.example.roomdbapp.DataBase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.roomdbapp.dao.ItemDAO;
import com.example.roomdbapp.model.Item;

@Database(entities = {Item.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ItemDAO getItemDAO();
}
