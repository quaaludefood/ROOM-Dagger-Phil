package com.example.room_dagger_phil.di.component;

import android.app.Application;

import com.example.room_dagger_phil.data.db.repository.AppDatabase;
import com.example.room_dagger_phil.data.db.dao.ActionDao;
import com.example.room_dagger_phil.data.db.repository.ActionRepository;
import com.example.room_dagger_phil.di.module.ApiModule;
import com.example.room_dagger_phil.di.module.AppModule;
import com.example.room_dagger_phil.di.module.RoomModule;
import com.example.room_dagger_phil.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(dependencies = {}, modules = {ApiModule.class, AppModule.class, RoomModule.class})
public interface AppComponent {

    void inject(MainActivity mainActivity);

    ActionDao actionDao();

    AppDatabase appDatabase();

    ActionRepository actionRepository();

    Application application();

}