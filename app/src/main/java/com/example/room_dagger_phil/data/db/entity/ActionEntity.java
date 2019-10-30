package com.example.room_dagger_phil.data.db.entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;


@Entity
public class ActionEntity {

    // Properties

    @PrimaryKey(autoGenerate = true)
    private int action_id;

    private boolean active;
    private String name;

    // Constructors

    public ActionEntity(boolean active, String name) {

        this.active = active;
        this.name = name;

    }

    // Methods

    public void setAction_id(int action_id) {

        this.action_id = action_id;
    }


    public int getAction_id() {
        return action_id;
    }
    public Boolean getActive() {
        return active;
    }
    public String getName() {
        return name;
    }

}
