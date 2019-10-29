package com.example.room_dagger_phil.data.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;


import com.example.room_dagger_phil.data.db.entity.ActionEntity;

import java.util.List;

@Dao
public interface ActionDao extends BaseDao<ActionEntity> {
    @Query("SELECT * FROM action_table")
    LiveData<List<ActionEntity>> getAll();

    @Query("SELECT * FROM action_table WHERE name LIKE :name")
    LiveData<List<ActionEntity>> findActionsByName(String name);

    @Query("SELECT * FROM action_table WHERE action_id = :id")
    LiveData<ActionEntity> findActionById(int id);
}