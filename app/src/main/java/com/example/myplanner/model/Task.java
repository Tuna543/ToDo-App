package com.example.myplanner.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Task implements Serializable {
    
    /**
     * Created the table and getter setter
     */


    @PrimaryKey(autoGenerate = true)
    int taskId;
    @ColumnInfo(name = "taskTitle")
    String taskTitle;
    @ColumnInfo(name = "taskDescription")
    String taskDescrption;
    @ColumnInfo(name = "date")
    String date;
    @ColumnInfo(name="time")
    String time;
   

    public Task() {

    }

    public int getTaskId() {return taskId;}
    public void setTaskId(int taskId) {this.taskId = taskId;}
    
    public String getTaskTitle() {return taskTitle;}
    public void setTaskTitle(String taskTitle) {this.taskTitle = taskTitle;}
    
    public String getTaskDescrption() {return taskDescrption;}
    public void setTaskDescrption(String taskDescrption) {this.taskDescrption = taskDescrption;}
    
    public String getDate() {return date;}
    public void setDate(String date) {this.date = date;}
    
    
    public String getTime() {return time;}
    public void setTime(String time) {this.time = time;}
    
   
}
