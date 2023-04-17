package com.example.quizzapp.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import static org.junit.Assert.assertEquals;

import androidx.lifecycle.LiveData;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import com.example.quizzapp.MainActivity;
import com.example.quizzapp.R;
import com.example.quizzapp.model.Item;
import com.example.quizzapp.model.ItemRepository;

import org.junit.Rule;
import org.junit.Test;

import java.util.List;

@LargeTest
public class registeredImagesTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule
            = new ActivityScenarioRule<>(MainActivity.class);

    private ItemRepository itemRepository;
    @Test
    public void test_correctNumberOfImages() {
        // Get the original length of list
        LiveData<List<Item>> liveDataItems = itemRepository.getAllItems();
        int size = liveDataItems.getValue().size();
        // Delete item at the first position in the recycler view
        onView(withId(R.id.recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        // Check if new length after deleting item is correct
        assertEquals(liveDataItems.getValue().size(), size-1);
        // Get new original length
        liveDataItems = itemRepository.getAllItems();
        int size2 = liveDataItems.getValue().size();
        // Add item to list

        // Check if new length after adding item is correct
        assertEquals(liveDataItems.getValue().size(), size2+1);
    }
}
