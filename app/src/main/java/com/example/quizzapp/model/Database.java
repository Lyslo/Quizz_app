package com.example.quizzapp.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Database {
    /*
    private static Database instance;
    private ItemDao itemDao;

    //This class uses an instance so that it can be globally accessible
    private Database(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    public static Database getInstance(ItemDao itemDao) {
        if (instance == null) {
            instance = new Database(itemDao);
        }
        return instance;
    }

    public List<Item> getItemList() {
        return itemDao.getAllItems();
    }

    public void removeItem(Item item) {
        itemDao.delete(item);
    }

    public void addItem(Item item) {
        itemDao.insert(item);
    }


    public void sortAz() {
        List<Item> itemList = itemDao.getAllItems();
        Collections.sort(itemList, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    public void sortZA() {
        List<Item> itemList = itemDao.getAllItems();
        Collections.sort(itemList, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o2.getName().compareTo(o1.getName());
            }
        });
    }

    public Item getRandomItem() {
       return itemDao.getRandomItem();
    }
*/
}
