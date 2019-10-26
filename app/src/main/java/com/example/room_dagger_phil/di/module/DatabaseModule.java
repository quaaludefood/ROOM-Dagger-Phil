package com.example.room_dagger_phil.di.module;

import android.content.Context;

import androidx.room.Room;

import com.example.room_dagger_phil.data.db.AppDatabase;
import com.example.room_dagger_phil.data.db.dao.ActionDao;
import com.example.room_dagger_phil.data.db.dao.PersonDao;
import com.example.room_dagger_phil.di.ApplicationContext;
import com.example.room_dagger_phil.di.DatabaseInfo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {
    @ApplicationContext
    private final Context mContext;

    @DatabaseInfo
    private final String mDBName = "my_database.db";

    public DatabaseModule (@ApplicationContext Context context) {
        mContext = context;
    }

    @Singleton
    @Provides
    AppDatabase provideDatabase () {
        return Room.databaseBuilder(
                mContext,
                AppDatabase.class,
                mDBName
        ).fallbackToDestructiveMigration().build();
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() { return mDBName; }

    @Singleton
    @Provides
    PersonDao providePersonDao(AppDatabase db) { return db.personDao(); }

    @Singleton
    @Provides
    ActionDao provideActionDao(AppDatabase db) { return db.actionDao(); }

}