package com.example.myplanner;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    @Rule
    public androidx.test.ext.junit.rules.ActivityScenarioRule<com.example.myplanner.activity.MainActivity> activityRule =
            new androidx.test.ext.junit.rules.ActivityScenarioRule<>(com.example.myplanner.activity.MainActivity.class);


    @Test
    public void testingadding()
    {
        onView(withId(R.id.addTask)).perform(click());
        onView(withId(R.id.taskadding)).check(androidx.test.espresso.assertion.ViewAssertions.matches(isDisplayed()));

        ViewActions.swipeUp();


        onView(withId(R.id.addTaskTitle)).perform(androidx.test.espresso.action.ViewActions.typeText("Web project"));
        pressBack();
        onView(withId(R.id.addTaskDescription)).perform(androidx.test.espresso.action.ViewActions.typeText("Web project submission"));
        pressBack();
        onView(withId(R.id.taskDate)).perform(androidx.test.espresso.action.ViewActions.typeText("20 July 2022"));

        pressBack();
        onView(withId(R.id.taskTime)).perform(androidx.test.espresso.action.ViewActions.typeText("18:30"));
        pressBack();

        onView(withId(R.id.addTask)).perform(click());
        onView(withId(R.id.listview)).check(androidx.test.espresso.assertion.ViewAssertions.matches(isDisplayed()));
    }


}