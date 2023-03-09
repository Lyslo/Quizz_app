package com.example.quizzapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.quizzapp.databinding.ActivityMainBinding;
import com.example.quizzapp.model.Database;
import com.example.quizzapp.model.Item;
import com.example.quizzapp.model.ItemDao;
import com.example.quizzapp.model.ItemDatabase;
import com.example.quizzapp.model.ItemRepository;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ItemRepository itemRepository;
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

        /*

        //Initialize database - ONLY NEEDS TO BE RUN ONCE FOR TESTING
        //Make a list of a few items

        // Create an instance of the ItemRepository class, passing in the ItemDao implementation
        // Get a reference to the AppDatabase

        itemRepository = new ItemRepository(getApplicationContext());

        // Decode the bitmaps
        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), getResources().getIdentifier("lilac_scottish_fold", "drawable", getPackageName()));
        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), getResources().getIdentifier("_00px_persialainen", "drawable", getPackageName()));
        Bitmap bitmap3 = BitmapFactory.decodeResource(getResources(), getResources().getIdentifier("_00px_gustav_chocolate", "drawable", getPackageName()));

        // Create the items
        Item item1 = new Item(bitmap1, "Scottish fold");
        Item item2 = new Item(bitmap2, "Persian");
        Item item3 = new Item(bitmap3, "Abyssian");

        // Insert the items into the database
        itemRepository.insert(item1);
        itemRepository.insert(item2);
        itemRepository.insert(item3);

        */
    }

}