package com.example.myplanner;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

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


    /**
     * UI Test for showing title in Main screen
     */


    @Test
    public void testMain() {
        onView(withText("Welcome to")).check(matches(isDisplayed())); //Check the name on the screen
        onView(withText("My Planner")).check(matches(isDisplayed()));  //Check the name on the screen
    }


    /**
     * UI Test for showing bottom sheet fragment
     */

    @Test
    public void bottomFragementAppear() {
        onView(withId(R.id.addTask)).perform(click()); //Click add button to add a record
        onView(withText("Fill the details below to add your TODO")).check(matches(isDisplayed()));
    }


    /**
     * UI Test for add a new task
     */

    @Test
    public void testingadding()  // testing for adding a new task
    {
        onView(withId(R.id.addTask)).perform(click()); // click on the add task button in homepage
        onView(withId(R.id.taskadding)).check(matches(isDisplayed())); // check bottomsheet fragment is displayed or not

        onView(withId(R.id.addTaskTitle)).perform(androidx.test.espresso.action.ViewActions.typeText("Web project")); // add title field
        pressBack(); //click back button

        onView(withId(R.id.addTaskDescription)).perform(androidx.test.espresso.action.ViewActions.typeText("Web project submission")); // add description field
        pressBack();  //click back button

        onView(withId(R.id.taskDate)).perform(androidx.test.espresso.action.ViewActions.typeText("20-07-2022")); // add date field
        pressBack();  //click back button

        onView(withId(R.id.taskTime)).perform(androidx.test.espresso.action.ViewActions.typeText("18:30")); // add time field
        pressBack();  //click back button

        onView(withId(R.id.addTask)).perform(click()); // click add task button in fragment
        onView(withId(R.id.taskRecycler)).check(matches(isDisplayed())); // check for added task in recycler view
    }
 /**
     * UI Test for updating  a Task
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
