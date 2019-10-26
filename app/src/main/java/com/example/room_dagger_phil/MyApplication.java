package com.example.room_dagger_phil;

import android.app.Application;

import com.example.room_dagger_phil.di.component.ApplicationComponent;
import com.example.room_dagger_phil.di.component.DaggerApplicationComponent;
import com.example.room_dagger_phil.di.module.ApplicationModule;
import com.example.room_dagger_phil.di.module.DatabaseModule;

public class MyApplication extends Application {

    protected ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

//TODO-You'd add Retrofit here .retrofitModule(new RetrofitModule(this))
     mApplicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .databaseModule(new DatabaseModule(this))
                .build();
        mApplicationComponent.inject(this);
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }
}