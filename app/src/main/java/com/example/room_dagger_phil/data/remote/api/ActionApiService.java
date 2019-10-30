package com.example.room_dagger_phil.data.remote.api;

import com.example.room_dagger_phil.data.remote.response.ActionApiResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ActionApiService {
    @GET("actions")
    Observable<ActionApiResponse> fetchActions();
}
