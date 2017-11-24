package com.larkintuckerllc.room;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import com.larkintuckerllc.room.db.AppDatabase;
import com.larkintuckerllc.room.db.Todo;
import java.util.List;

public class TodosViewModel extends AndroidViewModel {

    public final LiveData<List<Todo>> todos;

    private AppDatabase mDb;

    public TodosViewModel(Application application) {
        super(application);
        mDb = AppDatabase.getDatabase(getApplication());
        todos = mDb.todoModel().findAllTodos();
    }

    public void addTodo(String name, long date) {
        Todo todo = new Todo();
        todo.name = name;
        todo.date = date;
        mDb.todoModel().insertTodo(todo);
    }

    public void removeTodo(int id) {
        Todo todo = new Todo();
        todo.id = id;
        mDb.todoModel().deleteTodo(todo);
    }

}
