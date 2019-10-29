package com.example.room_dagger_phil.data.db.datasource;

import androidx.lifecycle.LiveData;

import com.example.room_dagger_phil.data.db.dao.ActionDao;
import com.example.room_dagger_phil.data.db.entity.ActionEntity;
import com.example.room_dagger_phil.data.db.repository.ActionRepository;

import javax.inject.Inject;

public class ActionDataSource implements ActionRepository {

    private ActionDao actionDao;

    @Inject
    public ActionDataSource(ActionDao actionDao) {
        this.actionDao = actionDao;
    }

    @Override
    public LiveData<ActionEntity> findActionById(int id) {
        return actionDao.findActionById(id);
    }

    @Override
    public LiveData<ActionEntity> findAll(int id) {
        return actionDao.findActionById(id);
    }
}
