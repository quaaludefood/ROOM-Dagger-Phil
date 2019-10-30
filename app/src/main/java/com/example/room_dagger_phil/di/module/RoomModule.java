package com.example.room_dagger_phil.di.module;

import android.app.Application;
import android.os.AsyncTask;

import androidx.room.Room;

import com.example.room_dagger_phil.data.db.entity.ActionEntity;
import com.example.room_dagger_phil.data.db.repository.AppDatabase;
import com.example.room_dagger_phil.data.db.dao.ActionDao;
import com.example.room_dagger_phil.data.db.repository.ActionDataSource;
import com.example.room_dagger_phil.data.db.repository.ActionRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {


    private AppDatabase appDatabase;

    public RoomModule(Application mApplication) {
        appDatabase = Room.databaseBuilder(mApplication, AppDatabase.class, "demo-db").build();
        new PopulateDbAsyncTask(appDatabase).execute();
    }

    @Singleton
    @Provides
    AppDatabase providesAppDatabase() {
        return appDatabase;
    }

    @Singleton
    @Provides
    ActionDao providesActionDao(AppDatabase appDatabase) {
        return appDatabase.getActionDao();
    }

    @Singleton
    @Provides
    ActionRepository actionRepository(ActionDao actionDao) {
        return new ActionDataSource(actionDao);
    }

    private class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private ActionDao actionDao;

        private PopulateDbAsyncTask(AppDatabase db)
        {
            actionDao = providesActionDao(db);
        }
        @Override
        protected Void doInBackground(Void... voids)
        {
            actionDao.insert(new ActionEntity(true, "This is a new action!"));
            actionDao.insert(new ActionEntity(true, "This is another new action..."));
            actionDao.insert(new ActionEntity( true, "This is yet another new action!"));
            return null;
        }
    }
}
