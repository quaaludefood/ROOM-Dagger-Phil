package com.example.room_dagger_phil.data.remote.response;

import com.example.room_dagger_phil.data.db.entity.ActionEntity;

import java.util.ArrayList;
import java.util.List;

public class ActionApiResponse {
    public ActionApiResponse() {
        this.actions = new ArrayList<>();
    }

    private List<ActionEntity> actions;

    public List<ActionEntity> getResults() {
        return actions;
    }

    public void setResults(List<ActionEntity> actions) {
        this.actions = actions;
    }
}
