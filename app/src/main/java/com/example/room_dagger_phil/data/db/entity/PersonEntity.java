package com.example.room_dagger_phil.data.db.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "person_table")
public class PersonEntity {

    // Properties

    @PrimaryKey(autoGenerate = true)
    public int person_id;


    public String name;


    public String email;
    // Constructors

    public PersonEntity(String email, String name) {

        this.email = email;
        this.name = name;
    }

    // Methods

    public void setPerson_id(int person_id) {

        this.person_id = person_id;
    }

    public int getPerson_id() {
        return person_id;
    }
    public String getEmail() {
        return email;
    }
    public String getName() {
        return name;
    }
}
