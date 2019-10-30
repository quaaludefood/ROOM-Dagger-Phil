package com.example.room_dagger_phil.data.db.repository;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.room_dagger_phil.data.db.dao.ActionDao;
import com.example.room_dagger_phil.data.db.entity.ActionEntity;
import com.example.room_dagger_phil.data.db.repository.ActionRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.Provides;

public class ActionDataSource implements ActionRepository {

    private ActionDao actionDao;

    @Inject
    public ActionDataSource(ActionDao actionDao) {
        this.actionDao = actionDao;
    }

    @Override
    public LiveData<ActionEntity> findActionById(int id) {
        return actionDao.findById(id);
    }

    @Override
    public LiveData<List<ActionEntity>> getAllActions() {
        return actionDao.findAll();
    }

    @Override
    public long insertAction(ActionEntity actionEntity) {
        return actionDao.insert(actionEntity);
    }

    @Override
    public int deleteAction(ActionEntity actionEntity) {
        return actionDao.delete(actionEntity);
    }

}
