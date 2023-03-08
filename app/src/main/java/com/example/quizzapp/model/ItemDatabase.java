package com.example.quizzapp.model;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.Database;


@Database(entities = {Item.class}, version = 1)
public abstract class ItemDatabase extends RoomDatabase {
    public abstract ItemDao itemDao();

    private static volatile ItemDatabase INSTANCE;

    public static ItemDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ItemDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    ItemDatabase.class, "item_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

