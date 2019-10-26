package com.example.room_dagger_phil.di.module;

import android.app.Application;
import android.content.Context;

import com.example.room_dagger_phil.di.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

//This module will hold the testApplication object over the application lifetime
//The ApplicationComponent will inject objects from this module to where you need them
@Module
public class ApplicationModule {
    private final Application mApplication;

    public ApplicationModule(Application app) {
        mApplication = app;
    }

    @Singleton
    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Singleton
    @Provides
    Application provideApplication() {
        return mApplication;
    }
}