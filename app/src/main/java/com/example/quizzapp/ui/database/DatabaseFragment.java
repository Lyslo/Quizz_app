package com.example.quizzapp.ui.database;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizzapp.R;

import java.util.ArrayList;
import java.util.List;

public class DatabaseFragment extends Fragment {

    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private List<Item> items;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_database, container, false);

        //Initiate the recyclerview
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //Make a list of a few items
        items = new ArrayList<>();
        items.add(new Item(R.drawable.lilac_scottish_fold, "Scottish fold"));
        items.add(new Item(R.drawable._00px_persialainen, "Persian"));
        items.add(new Item(R.drawable._00px_gustav_chocolate, "Abyssian"));
        // Add more items as needed

        adapter = new MyAdapter(items);
        recyclerView.setAdapter(adapter);

        return view;
    }
}