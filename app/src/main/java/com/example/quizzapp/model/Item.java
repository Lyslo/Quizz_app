package com.example.quizzapp.model;

import android.graphics.Bitmap;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

@Entity(tableName = "item_table")
@TypeConverters(Converters.class)
public class Item {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private Bitmap image;
    private String name;

    public Item(Bitmap image, String name) {
        this.image = image;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bitmap getImage() {
        return image;
    }

    public String getName() {
        return name;
    }
}

