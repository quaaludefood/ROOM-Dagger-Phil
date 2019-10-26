package com.example.room_dagger_phil.data.db.entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;


@Entity(tableName = "action_table",
        indices = {@Index(name = "person_idx", value = {"person_id"})},
        foreignKeys = {@ForeignKey(entity = PersonEntity.class,
                parentColumns = {"person_id"},
                childColumns = {"person_id"},
                onDelete = ForeignKey.CASCADE)
        }
)
public class ActionEntity {

    // Properties

    @PrimaryKey(autoGenerate = true)
    private int action_id;

    private boolean active;
    private String name;
    private int person_id;

    // Constructors

    public ActionEntity(boolean active, String name, int person_id) {

        this.active = active;
        this.name = name;
        this.person_id = person_id;
    }

    // Methods

    public void setAction_id(int action_id) {

        this.action_id = action_id;
    }

    public int getPerson_id() {
        return person_id;
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
