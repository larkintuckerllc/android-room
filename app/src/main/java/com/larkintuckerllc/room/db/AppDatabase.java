package com.larkintuckerllc.room.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Todo.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract TodoDao todoModel();

    // TODO: PERSIST DB
    public static AppDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "com.larkintuckerllc.room.db")
                    // IN THIS EXAMPLE USED FOR SIMPLICITY
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

}
