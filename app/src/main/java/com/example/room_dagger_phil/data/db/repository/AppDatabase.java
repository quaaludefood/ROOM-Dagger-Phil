package com.example.room_dagger_phil.data.db.repository;

import androidx.room.RoomDatabase;
import androidx.room.Database;

import com.example.room_dagger_phil.data.db.dao.ActionDao;
import com.example.room_dagger_phil.data.db.entity.ActionEntity;


@Database(entities = {ActionEntity.class}, version = AppDatabase.VERSION, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    static final int VERSION = 1;
    public abstract ActionDao getActionDao();
}