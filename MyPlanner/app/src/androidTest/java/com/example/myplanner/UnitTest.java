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
     * Unit Test For deleting
     */


    @Test
    public void testDelete() throws Exception{
        Task createTask = new Task();
        createTask.setTaskId(3);
        createTask.setTaskTitle("Project");
        createTask.setTaskDescrption("Software Project Submission");
        createTask.setDate("26-07-2022");
        createTask.setTime("14:30");

        dao.insertDataIntoTaskList(createTask);
        Task record1 = dao.selectDataFromAnId(3);

        assertEquals("Project", record1.getTaskTitle());
        dao.deleteTaskFromId(3);

        assertNull(dao.selectDataFromAnId(3));
    }
}
