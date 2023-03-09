package com.example.quizzapp.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ItemDao {
    @Insert
    void insert(Item item);

    @Update
    void update(Item item);

    @Delete
    void delete(Item item);

    @Query("SELECT * FROM item_table")
    LiveData<List<Item>> getAllItems();

    @Query("SELECT * FROM item_table ORDER BY RANDOM() LIMIT 1")
    LiveData<Item> getRandomItem();

    @Query("SELECT * FROM item_table ORDER BY name ASC")
    LiveData<List<Item>> getAllItemsSortedAZ();

    @Query("SELECT * FROM item_table ORDER BY name DESC")
    LiveData<List<Item>> getAllItemsSortedZA();
}

