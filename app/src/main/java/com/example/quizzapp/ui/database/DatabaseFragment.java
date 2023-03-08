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
import com.example.quizzapp.model.ItemDao;
import com.example.quizzapp.model.ItemDatabase;

import java.util.ArrayList;

public class DatabaseFragment extends Fragment implements RecyclerViewInterface {

    private RecyclerView recyclerView;
    private ItemDao itemDao;
    private com.example.quizzapp.model.ItemDatabase ItemDatabase;

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

        View.OnClickListener l = view1 -> extracted(view1 == myButton);

        //Button sort A-Z
        myButton.setOnClickListener(l);

        //Button sort Z-A
        myButton2.setOnClickListener(l);

        //Initiate the recyclerview
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //get the items from the db

        // Get instance of the database
        ItemDatabase itemDatabase = ItemDatabase.getDatabase(getContext());

        // Get instance of the DAO
        ItemDao itemDao = itemDatabase.itemDao();

        MyAdapter adapter = new MyAdapter(itemDao.getAllItems(), this);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private void extracted(Boolean atoz) {

        // Get instance of the database
        ItemDatabase itemDatabase = ItemDatabase.getDatabase(getContext());

        // Get instance of the DAO
        ItemDao itemDao = itemDatabase.itemDao();
        // Sort from Z-A
        /*
        if(atoz) {
            database.sortAz();
        }else{
            database.sortZA();
        }
        */
        //Refresh the fragment (and update the UI)
        recyclerView.getAdapter().notifyDataSetChanged();
    }

    //The method below is executed when an item in the recyclerview is clicked
    public void onItemClick(int position) {
        // Get the items from the db
        // Get instance of the database
        ItemDatabase itemDatabase = ItemDatabase.getDatabase(getContext());

        // Get instance of the DAO
        ItemDao itemDao = itemDatabase.itemDao();

        //Remove item from db
        //database.removeItem(position);

        //Refresh the fragment (and update the UI)
        recyclerView.getAdapter().notifyDataSetChanged();
    }

}