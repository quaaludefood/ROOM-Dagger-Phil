package com.example.room_dagger_phil.di.module;

import com.example.room_dagger_phil.data.remote.api.ActionApiService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

@Module
public class ApiModule {

    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkhttpClient(Cache cache) {


        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.cache(cache);
        httpClient.connectTimeout(30, TimeUnit.SECONDS);
        httpClient.readTimeout(30, TimeUnit.SECONDS);
        return httpClient.build();
    }


    /*
     * The method returns the Retrofit object
     * */
    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl("http://mylabdaemon.thefusion.works/api/")
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    ActionApiService provideActionApiService(Retrofit retrofit) {
        return retrofit.create(ActionApiService.class);
    }

}
