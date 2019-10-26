package com.example.room_dagger_phil.data.db.dao;

import androidx.room.Dao;
import androidx.room.Query;


import com.example.room_dagger_phil.data.db.entity.ActionEntity;

import java.util.List;

@Dao
public interface ActionDao extends BaseDao<ActionEntity> {
    @Query("SELECT * FROM action_table")
    List<ActionEntity> getAll();

    @Query("SELECT * FROM action_table WHERE name LIKE :name")
    List<ActionEntity> findActionsByName(String name);
}