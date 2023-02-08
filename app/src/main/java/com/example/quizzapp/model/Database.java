package com.example.quizzapp.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Database {
    private static Database instance;
    private ArrayList<Item> itemList;

    //This class uses an instance so that it can be globally accessible
    private Database() {
    }

    public Database(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }

    public static Database getInstance(ArrayList<Item> itemList) {
        if (instance == null) {
            instance = new Database(itemList);
        }
        return instance;
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }

    public void removeItem(int pos) {
        itemList.remove(pos);
    }

    public void addItem(Item item) {
        itemList.add(item);
    }


    public void sortAz() {

        Collections.sort(itemList, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    public void sortZA() {
        Collections.sort(itemList, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o2.getName().compareTo(o1.getName());
            }
        });
    }

    public Item getRandomItem() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(itemList.size());
        Item randomItem = itemList.get(randomIndex);
        return randomItem;
    }

}
