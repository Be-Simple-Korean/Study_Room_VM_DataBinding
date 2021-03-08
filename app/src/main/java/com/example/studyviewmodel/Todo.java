package com.example.studyviewmodel;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Todo { //룸에 들어갈 데이터가 될 클래스 어노테이션으로 테이블과 기본키등을 설정
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;

    public Todo(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
