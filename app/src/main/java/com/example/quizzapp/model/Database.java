package com.example.quizzapp.model;

import java.util.ArrayList;

public class Database {
    private static Database instance;
    private ArrayList<Item> itemList;

    //This class uses an instance so that it can be globally accessible
    private Database() {}

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

    public void removeItem(int pos){
        itemList.remove(pos);
    }

}
