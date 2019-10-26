package com.example.room_dagger_phil.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Person;
import android.os.Bundle;

import com.example.room_dagger_phil.MyApplication;
import com.example.room_dagger_phil.R;
import com.example.room_dagger_phil.data.db.AppDatabase;
import com.example.room_dagger_phil.data.db.Executor;
import com.example.room_dagger_phil.data.db.dao.PersonDao;
import com.example.room_dagger_phil.data.db.entity.PersonEntity;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {


    @Inject
    AppDatabase mAppDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((MyApplication)getApplication()).getComponent().inject(this);
        final PersonDao personDao = mAppDatabase.personDao();
        Executor.IOThread(() -> personDao.insert(new PersonEntity("flame@dramon.com", "a new perosn")));
    }
}
