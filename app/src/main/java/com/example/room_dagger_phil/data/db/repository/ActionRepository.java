package com.example.room_dagger_phil.data.db.repository;

import androidx.lifecycle.LiveData;

import com.example.room_dagger_phil.data.db.entity.ActionEntity;

import java.util.List;

public interface ActionRepository {

    LiveData<ActionEntity> findActionById(int id);

    LiveData<List<ActionEntity>> findAll();

    long insert(ActionEntity actionEntity);

    int delete(ActionEntity actionEntity);
}
