package com.example.quizzapp.ui.database;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizzapp.R;
import com.example.quizzapp.model.Database;
import com.example.quizzapp.model.Item;

import java.util.ArrayList;

public class DatabaseFragment extends Fragment implements RecyclerViewInterface{

    private RecyclerView recyclerView;
    private MyAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_database, container, false);

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
    @Override
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
}