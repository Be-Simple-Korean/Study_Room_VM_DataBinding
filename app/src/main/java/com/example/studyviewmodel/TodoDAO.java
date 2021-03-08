package com.example.studyviewmodel;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao //DATA ACCESS OBJECT = 룸에 있는 데이터에 접근하는 객체
// = 데이터 접근 = SELECT, INSERT, UPDATE , DELETE
interface TodoDAO {
    @Query("SELECT * FROM Todo")
    LiveData<List<Todo>> getAll(); //라이브 데이터를 감싸주면 getAll 메소드는 관찰 가능한 객체가 됨

    @Insert
    void insert(Todo todo);

    @Update
    void update(Todo todo);

    @Delete
    void delete(Todo todo);
}
