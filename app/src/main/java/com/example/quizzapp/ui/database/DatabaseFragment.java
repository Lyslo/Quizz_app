package com.example.quizzapp.ui.database;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizzapp.R;
import com.example.quizzapp.model.Database;
import com.example.quizzapp.model.Item;

import java.util.ArrayList;

public class DatabaseFragment extends Fragment implements RecyclerViewInterface {

    private RecyclerView recyclerView;
    private MyAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_database, container, false);
        // Set up buttons
        Button myButton;
        Button myButton2;
        // Fetch the correct button id
        myButton = view.findViewById(R.id.button3);
        myButton2 = view.findViewById(R.id.button4);

        //Button sort A-Z
        myButton.setOnClickListener(v -> {

            // Get the items from the db
            ArrayList<Item> itemList = new ArrayList<>();
            Database database = Database.getInstance(itemList);
            // Sort form A-Z
            database.sortAz();

            //Refresh the fragment (and update the UI)
            adapter = new MyAdapter(database.getItemList(), this);
            recyclerView.setAdapter(adapter);
        });

        //Button sort Z-A
        myButton2.setOnClickListener(v -> {

            // Get the items from the db
            ArrayList<Item> itemList = new ArrayList<>();
            Database database = Database.getInstance(itemList);
            // Sort from Z-A
            database.sortZA();

            //Refresh the fragment (and update the UI)
            adapter = new MyAdapter(database.getItemList(), this);
            recyclerView.setAdapter(adapter);
        });


        //Initiate the recyclerview
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //get the items from the db
        ArrayList<Item> itemList = new ArrayList<>();
        Database database = Database.getInstance(itemList);

        adapter = new MyAdapter(database.getItemList(), this);
        recyclerView.setAdapter(adapter);

        return view;
    }

    //The method below is executed when an item in the recyclerview is clicked
    public void onItemClick(int position) {
        // Get the items from the db
        ArrayList<Item> itemList = new ArrayList<>();
        Database database = Database.getInstance(itemList);

        //Remove item from db
        database.removeItem(position);

        //Refresh the fragment (and update the UI)
        adapter = new MyAdapter(database.getItemList(), this);
        recyclerView.setAdapter(adapter);
    }

}