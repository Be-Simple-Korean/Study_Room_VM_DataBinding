package com.example.studyviewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import com.example.studyviewmodel.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding main;
    private MainViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vm = ViewModelProviders.of(this)
                .get(MainViewModel.class);
        main = DataBindingUtil.setContentView(this,R.layout.activity_main);
        main.setLifecycleOwner(this); //라이브데이터도 DataBinding에 반영
        main.setViewModel(vm);//뷰모델도 바인딩에 반영
    }


}