package com.example.room_dagger_phil.data.db.dao;

import androidx.room.Dao;
import androidx.room.Query;


import com.example.room_dagger_phil.data.db.entity.PersonEntity;

import java.util.List;

@Dao
public interface PersonDao extends BaseDao<PersonEntity> {
    @Query("SELECT * FROM person_table")
    List<PersonEntity> getAll();

    @Query("SELECT * FROM person_table WHERE name LIKE :name")
    List<PersonEntity> findPersonsByName(String name);
}