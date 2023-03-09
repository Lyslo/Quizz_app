package com.example.quizzapp.model;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;


public class ItemRepository {
    private ItemDao itemDao;

    public ItemRepository(Context context) {
        ItemDatabase db = ItemDatabase.getDatabase(context);
        itemDao = db.itemDao();
    }

    public void insert(Item item) {
        new Thread(() -> {
            itemDao.insert(item);
        }).start();
    }

    public void update(Item item) {
        new Thread(() -> {
            itemDao.update(item);
        }).start();
    }

    public void delete(Item item) {
        new Thread(() -> {
            itemDao.delete(item);
        }).start();
    }

    public LiveData<List<Item>> getAllItems() {
        return itemDao.getAllItems();
    }

    public LiveData<Item> getRandomItem() {
        return itemDao.getRandomItem();
    }

    public LiveData<List<Item>> getAllItemsSortedAZ() {
        return itemDao.getAllItemsSortedAZ();
    }

    public LiveData<List<Item>> getAllItemsSortedZA() {
        return itemDao.getAllItemsSortedZA();
    }
}

