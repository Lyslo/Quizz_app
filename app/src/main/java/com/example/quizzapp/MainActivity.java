package com.example.quizzapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.quizzapp.R;
import com.example.quizzapp.model.Database;
import com.example.quizzapp.model.Item;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.quizzapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_database, R.id.navigation_quiz, R.id.navigation_newEntry)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);


        //Initialize database
        //Make a list of a few items
        ArrayList<Item> itemList = new ArrayList<>();

        Database database = Database.getInstance(itemList);


        Item item1 = new Item(R.drawable.lilac_scottish_fold, "Scottish fold");
        Item item2 = new Item(R.drawable._00px_persialainen, "Persian");
        Item item3 = new Item(R.drawable._00px_gustav_chocolate, "Abyssian");

        database.getItemList().add(item1);
        database.getItemList().add(item2);
        database.getItemList().add(item3);

       

    }

}