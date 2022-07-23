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
 /**
     * UI Test for update a Task
     */


    @Test
    public void testingUpdate()
    {

        onView(withId(R.id.options)).perform(click()); // click option button in main screen
        onView(withText("Update")).perform(click());  // click Update
        onView(withId(R.id.addTaskTitle)).perform(ViewActions.clearText(),ViewActions.typeText("Software Lab")); // update title field
        pressBack(); //click back button
        onView(withId(R.id.addTaskDescription)).perform(ViewActions.clearText(),ViewActions.typeText("Project Submission")); // update description field
        pressBack();  //click back button
        onView(withId(R.id.taskDate)).perform(ViewActions.clearText(),ViewActions.typeText("27-07-2022")); // update date field
        pressBack();  //click back button
        onView(withId(R.id.addTask)).perform(click()); // click add Task button

    }

    /**
     * UI Test for delete a task
     */

    @Test
    public void testingDelete() {
        onView(withId(R.id.options)).perform(click()); // click option button in main screen
        onView(withText("Delete")).perform(click()); // click Delete
        onView(withText("YES")).perform(click()); // click yes button
    }


    /**
     * UI Test for complete a task
     */

    @Test
    public void testingComplete() {
        onView(withId(R.id.options)).perform(click()); // click option button in main screen
        onView(withText("Complete")).perform(click());// click Complete
        onView(withText("YES")).perform(click()); // click yes button
        onView(withId(R.id.closeButton)).perform(click()); // click done button
    }

    public static class SplashActivityTest {

        @Rule
        public androidx.test.ext.junit.rules.ActivityScenarioRule<com.example.myplanner.activity.SplashActivity> activityRule =
                new androidx.test.ext.junit.rules.ActivityScenarioRule<>(com.example.myplanner.activity.SplashActivity.class);


        /**
         * UI Test for splash screen
         */

        @Test
        public void testsplashscreen()
        {
            onView(withId(R.id.logo)).check(matches(isDisplayed()));  // check for splash screen
            onView(withText("My Planner")).check(matches(isDisplayed())); // check for text "My Planner"
            onView(withText("organize work by outstanding manager")).check(matches(isDisplayed())); // check for text
            onView(withText("- Make Schedule")).check(matches(isDisplayed()));  // check for text
            onView(withText("- Manage Time")).check(matches(isDisplayed()));  // check for text
            onView(withText("- Stay Focused")).check(matches(isDisplayed())); // check for text
        }


    }

}
