package com.example.room_dagger_phil.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import com.example.room_dagger_phil.R;
import com.example.room_dagger_phil.data.db.dao.ActionDao;
import com.example.room_dagger_phil.data.db.entity.ActionEntity;
import com.example.room_dagger_phil.data.db.repository.ActionRepository;
import com.example.room_dagger_phil.di.component.DaggerAppComponent;
import com.example.room_dagger_phil.di.module.AppModule;
import com.example.room_dagger_phil.di.module.RoomModule;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    public ActionRepository actionRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerAppComponent.builder()
                .appModule(new AppModule(getApplication()))
                .roomModule(new RoomModule(getApplication()))
                .build()
                .inject(this);

       // PopulateDbAsyncTask.execute();
        actionRepository.getAllActions().observe(this, new Observer<List<ActionEntity>>() {
            @Override
            public void onChanged(@Nullable List<ActionEntity> products) {
                Toast.makeText(MainActivity.this, String.format("Product size: %s", products.size()), Toast.LENGTH_SHORT).show();
            }
        });
    }

}