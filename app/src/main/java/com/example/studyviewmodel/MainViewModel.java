package com.example.studyviewmodel;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.room.Room;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    //뷰모델 = ui와 로직을 분리하여 로직을 주로 담당
    //하나의 생명주기만을 가지기 때문에 앱이 끝나기 전까지 데이터를 유지
    //LiveData- DB의 데이터를 관찰해서 자동으로 갱신
    //관찰 -  삭제, 추가, 변경
    //Databinding- xml로 값이 넘어가게 할수도있고 (@{}),
    //XML에서 값이 넘어오게 할수도 있음 (@={})
    private AppDatabase db;
    public LiveData<List<Todo>> todos;
    public String newTodo;
    public MainViewModel(@NonNull Application application) {
        super(application);
        db = Room.databaseBuilder(
                application,AppDatabase.class,"Todo-DB")
                .build();
        todos=getAll();
    }
    public void insert(String data){
        new InsertAsyncTask(db.todoDao()).execute(new Todo(data));
    }

    public LiveData<List<Todo>> getAll(){
        return db.todoDao().getAll();
    }
    //DB의 데이터 처리는 백그라운드에서 동작 해야함.
    private static class InsertAsyncTask extends AsyncTask<Todo,Void,Void> {
        private TodoDAO todoDAO;

        public InsertAsyncTask(TodoDAO todoDAO) {
            this.todoDAO = todoDAO;
        }

        @Override
        protected Void doInBackground(Todo... todos) {
            todoDAO.insert(todos[0]);
            return null;
        }
    }
}
