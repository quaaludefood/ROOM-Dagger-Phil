package com.example.room_dagger_phil.data.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;


import com.example.room_dagger_phil.data.db.entity.ActionEntity;

import java.util.List;

@Dao
public interface ActionDao {

    @Query("SELECT * FROM ActionEntity WHERE action_id=:id")
    LiveData<ActionEntity> findById(int id);

    @Query("SELECT * FROM ActionEntity")
    LiveData<List<ActionEntity>> findAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(ActionEntity actionEntity);

    @Delete
    int delete(ActionEntity actionEntity);
}