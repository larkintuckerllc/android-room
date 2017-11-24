package com.larkintuckerllc.room.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import java.util.List;
import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface TodoDao {

    @Query("SELECT * FROM Todo")
    LiveData<List<Todo>> findAllTodos();

    @Insert(onConflict = REPLACE)
    void insertTodo(Todo todo);

    @Delete
    void deleteTodo(Todo todo);

}
