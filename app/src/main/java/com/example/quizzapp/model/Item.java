package com.example.quizzapp.model;

public class Item {

    private int image;
    private String name;

    public Item(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }
}

