package com.example.studyviewmodel;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Todo.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    //데이터베이스 객체
    public abstract TodoDAO todoDao();
}
