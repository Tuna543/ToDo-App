
package com.example.myplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;


import com.example.myplanner.database.AppDatabase;
import com.example.myplanner.database.OnDataBaseAction;
import com.example.myplanner.model.Task;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;




         /**
         * on This class we will do some unit test for our application
         */


    @RunWith(AndroidJUnit4.class)
    public class UnitTest {
        private AppDatabase database;
        private OnDataBaseAction dao;

        @Before
        public void setup(){
            database = Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(),
                    AppDatabase.class).build();

            dao = database.dataBaseAction();
        }

        @After
        public void teardown() throws IOException {
            database.close();
        }


        /**
         * Unit Test For adding
         */


        @Test
        public void testAdd() throws Exception{
            Task createTask = new Task();
            createTask.setTaskId(1);        // setting task id
            createTask.setTaskTitle("Meeting");  //insert task Title
            createTask.setTaskDescrption("Meeting with Management Team"); //insert task Description
            createTask.setDate("25-7-2022");           //insert task date
            createTask.setTime("18:25");         //insert task time 

            dao.insertDataIntoTaskList(createTask);
            Task record1 = dao.selectDataFromAnId(1); // save task in database

            assertEquals("Meeting", record1.getTaskTitle()); //getting back the record from database

        }

        /**
         * Unit Test For updating
         */


        @Test
        public void testUpdate() throws Exception{
            Task createTask = new Task();
            createTask.setTaskId(2);  // setting task id
            createTask.setTaskTitle("Meeting");  //insert task Title
            createTask.setTaskDescrption("Meeting with Management Team");  //insert task Description
            createTask.setDate("25-07-2022");  //insert task date
            createTask.setTime("18:25");   //insert task time 

            dao.insertDataIntoTaskList(createTask);
            Task record1 = dao.selectDataFromAnId(2);   // save task in database

            assertEquals("Meeting", record1.getTaskTitle());  

            dao.updateAnExistingRow(2,"Meeting","Meeting with Management Team","27-07-2022","18:25"); 
            record1 = dao.selectDataFromAnId(2);  //select task id 2 for updating
            assertEquals("27-07-2022", record1.getDate());
        }
        
          /**
         * Unit Test For deleting
         */
         
        @Test
        public void testDelete() throws Exception{
        Task createTask = new Task();
        createTask.setTaskId(3);   // setting task id
        createTask.setTaskTitle("Project");  //insert task Title
        createTask.setTaskDescrption("Software Project Submission");  //insert task Description
        createTask.setDate("26-07-2022");  //insert task date
        createTask.setTime("14:30");  //insert task time 

        dao.insertDataIntoTaskList(createTask);
        Task record1 = dao.selectDataFromAnId(3);  // save task in database

        assertEquals("Project", record1.getTaskTitle());
        dao.deleteTaskFromId(3);  //delete from database

        assertNull(dao.selectDataFromAnId(3)); //if can not find task id 3 , then give null
         
    }
}
