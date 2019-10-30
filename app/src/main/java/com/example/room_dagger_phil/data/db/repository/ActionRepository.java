package com.example.room_dagger_phil.data.db.repository;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.room_dagger_phil.data.db.dao.ActionDao;
import com.example.room_dagger_phil.data.db.entity.ActionEntity;

import java.util.List;

import dagger.Provides;

public interface ActionRepository {

    LiveData<ActionEntity> findActionById(int id);

    LiveData<List<ActionEntity>> getAllActions();


     long insertAction(ActionEntity actionEntity);

    int deleteAction(ActionEntity actionEntity);



}
