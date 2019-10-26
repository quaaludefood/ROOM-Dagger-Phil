package com.example.room_dagger_phil.di.component;

import android.app.Application;
import android.content.Context;

import com.example.room_dagger_phil.MyApplication;
import com.example.room_dagger_phil.di.ApplicationContext;
import com.example.room_dagger_phil.di.DatabaseInfo;
import com.example.room_dagger_phil.di.module.ApplicationModule;
import com.example.room_dagger_phil.di.module.DatabaseModule;
import com.example.room_dagger_phil.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        DatabaseModule.class,
})

//This injects objects from module to where they are needed
//It injects from both the Application and Database modules

public interface ApplicationComponent {
    void inject (MyApplication myApplication);
    void inject (MainActivity mainActivity);

    @ApplicationContext
    Context getContext();

    Application getApplication();

    @DatabaseInfo
    String getDatabaseName();
}