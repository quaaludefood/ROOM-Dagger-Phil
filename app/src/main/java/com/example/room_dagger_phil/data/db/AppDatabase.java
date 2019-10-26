package com.example.room_dagger_phil.data.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.RoomDatabase;
import androidx.room.Database;

import com.example.room_dagger_phil.data.db.dao.ActionDao;
import com.example.room_dagger_phil.data.db.dao.PersonDao;
import com.example.room_dagger_phil.data.db.entity.ActionEntity;
import com.example.room_dagger_phil.data.db.entity.PersonEntity;

@Database(entities = {PersonEntity.class, ActionEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PersonDao personDao();
    public abstract ActionDao actionDao();
}