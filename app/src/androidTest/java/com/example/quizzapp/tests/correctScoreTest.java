package com.example.quizzapp.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import com.example.quizzapp.MainActivity;
import com.example.quizzapp.QuizActivity;
import com.example.quizzapp.R;
import com.example.quizzapp.model.Item;

import org.junit.Rule;
import org.junit.Test;

@LargeTest
public class correctScoreTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule
            = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void test_correctScore() {
        // Get into the quiz fragment
        onView(withId(R.id.navigation_quiz))
                .perform(click());
        // Start easy quiz
        onView(withId(R.id.button6))
                .perform(click());

        // Get correct answer from quiz
        Item correctItem = QuizActivity.getCurrentItem();
        String correctAnswer = correctItem.getName();

        // Press the button that has the correct answer
        onView(withText(correctAnswer))
                .perform(click());

        // Press the next button
        onView(withId(R.id.button4))
                .perform(click());

        // Check that the score has been updated correctly
        onView(withId(R.id.score)).check(matches(withText("Score: 1 / 1")));

    }
}
