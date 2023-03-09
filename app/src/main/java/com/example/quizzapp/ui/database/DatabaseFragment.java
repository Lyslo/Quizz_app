package com.example.quizzapp.ui.database;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizzapp.R;
import com.example.quizzapp.model.Database;
import com.example.quizzapp.model.Item;
import com.example.quizzapp.model.ItemDao;
import com.example.quizzapp.model.ItemDatabase;
import com.example.quizzapp.model.ItemRepository;

import java.util.ArrayList;
import java.util.List;

public class DatabaseFragment extends Fragment implements RecyclerViewInterface {

    private RecyclerView recyclerView;
    private ItemRepository itemRepository;
    MyAdapter adapter;

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

        View.OnClickListener l = view1 -> sortItems(view1 == myButton);

        //Button sort A-Z
        myButton.setOnClickListener(l);

        //Button sort Z-A
        myButton2.setOnClickListener(l);

        //Initiate the recyclerview
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //get the items from the db

        itemRepository = new ItemRepository(getContext());

        //Initiate the recyclerview with a list of items
        itemRepository.getAllItems().observe(this, items -> {
            // Do something with the list of items

            adapter = new MyAdapter(items, this);
            recyclerView.setAdapter(adapter);
        });


        return view;
    }

    public void sortItems(boolean ascending) {
        if (ascending) {
            itemRepository.getAllItemsSortedAZ().observe(this, items -> {
                // Update the adapter with the list of items sorted from A to Z
                adapter.setItems(items);
            });
        } else {
            itemRepository.getAllItemsSortedZA().observe(this, items -> {
                // Update the adapter with the list of items sorted from Z to A
                adapter.setItems(items);
            });
        }
    }

    //The method below is executed when an item in the recyclerview is clicked
    public void onItemClick(int position) {
        // Get the LiveData object for all items
        LiveData<List<Item>> liveDataItems = itemRepository.getAllItems();

        // Observe the LiveData object for changes
        liveDataItems.observe(this, items -> {
            // Get the item at the clicked position
            Item itemToDelete = items.get(position);

            // Remove the item from the db
            itemRepository.delete(itemToDelete);

            // Update the adapter with the new list of items
            adapter.setItems(items);

            // Stop observing the LiveData object to avoid memory leaks
            liveDataItems.removeObservers(this);
        });
    }


}