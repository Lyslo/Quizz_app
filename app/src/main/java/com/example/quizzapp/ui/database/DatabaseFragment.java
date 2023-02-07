package com.example.quizzapp.ui.database;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

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


        //Button sort A-Z
        View view = inflater.inflate(R.layout.fragment_database, container, false);
        Button myButton;
        Button myButton2;
        myButton = view.findViewById(R.id.button3);
        myButton2 = view.findViewById(R.id.button4);
        myButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                //get the items from the db
                ArrayList<Item> itemList = new ArrayList<>();
                Database database = Database.getInstance(itemList);
                database.sortAz();

                //Refresh the fragment (and update the UI)
                adapter = new MyAdapter(database.getItemList(), DatabaseFragment.this);
                recyclerView.setAdapter(adapter);
            }
        });

        myButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                //get the items from the db
                ArrayList<Item> itemList = new ArrayList<>();
                Database database = Database.getInstance(itemList);
                database.sortZA();

                //Refresh the fragment (and update the UI)
                adapter = new MyAdapter(database.getItemList(), DatabaseFragment.this);
                recyclerView.setAdapter(adapter);
            }
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
        //get the items from the db
        ArrayList<Item> itemList = new ArrayList<>();
        Database database = Database.getInstance(itemList);

        //Remove item from db
        database.removeItem(position);

        //Refresh the fragment (and update the UI)
        adapter = new MyAdapter(database.getItemList(), this);
        recyclerView.setAdapter(adapter);
    }

    //Handles button presses


    public void onClick(View v) {
        // Do something in response to button click
        //get the items from the db
        ArrayList<Item> itemList = new ArrayList<>();
        Database database = Database.getInstance(itemList);

        //Check for what button is pressed
        switch (v.getId()) {
            case R.id.button3:
                database.sortAz();
                break;
            case R.id.button4:
                database.sortZA();
                break;
        }

        //Refresh the fragment (and update the UI)
        adapter = new MyAdapter(database.getItemList(), DatabaseFragment.this);
        recyclerView.setAdapter(adapter);

    }
}