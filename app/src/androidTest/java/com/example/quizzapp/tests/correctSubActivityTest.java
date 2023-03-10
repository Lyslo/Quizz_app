package com.example.quizzapp.tests;


import static androidx.test.core.app.ApplicationProvider.getApplicationContext;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.Manifest;
import android.content.ComponentName;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.rule.GrantPermissionRule;

import com.example.quizzapp.MainActivity;
import com.example.quizzapp.QuizActivity;
import com.example.quizzapp.R;
import com.example.quizzapp.ui.newEntry.NewEntryFragment;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

@LargeTest
public class correctSubActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule
            = new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setUp(){
        Intents.init();
    }

    @After
    public void tearDown(){
        Intents.release();
    }

    @Test
    public void test_correctSubActivity_buttonClick(){
        // Get into the quiz fragment
        onView(withId(R.id.navigation_quiz))
                .perform(click());
        // Find the button and click it
        onView(withId(R.id.button6))
                .perform(click());

        //Check that the correct sub-activity is launched
        intended(hasComponent(new ComponentName(getApplicationContext(), QuizActivity.class)));
    }
}
