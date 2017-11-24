package com.larkintuckerllc.room.db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Todo {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;
    public long date;

    public boolean equals(Todo todo) {
        return todo.id == id &&
                todo.name == name &&
                todo.date == date;
    }
}
