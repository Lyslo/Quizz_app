package com.example.quizzapp.tests;

import static androidx.test.InstrumentationRegistry.getTargetContext;
import static androidx.test.core.app.ApplicationProvider.getApplicationContext;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.Manifest;
import android.content.ComponentName;

import androidx.lifecycle.LiveData;
import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.rule.GrantPermissionRule;

import com.example.quizzapp.MainActivity;
import com.example.quizzapp.R;
import com.example.quizzapp.model.Item;
import com.example.quizzapp.model.ItemRepository;
import com.example.quizzapp.ui.newEntry.NewEntryFragment;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

@LargeTest
public class registeredImagesTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule
            = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void test_correctNumberOfImages() {
        onView(withId(R.id.recycler_view))
                .perform(click());
    }
}
