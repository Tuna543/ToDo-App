package com.example.myplanner.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.myplanner.model.Task;

import java.util.List;

@Dao
public interface OnDataBaseAction {

    @Query("SELECT * FROM Task")
    List<Task> getAllTasksList();

    @Query("DELETE FROM Task")
    void truncateTheList();
    
     /**This will insert the data
     *
     * @param task
     */

    @Insert
    void insertDataIntoTaskList(Task task);
    
    
     /**This will delete the task
     *
     * @param taskId
     */

    @Query("DELETE FROM Task WHERE taskId = :taskId")
    void deleteTaskFromId(int taskId);
    
     /**This will return the task details
     *
     * @param taskId
     * @return task
     */

    @Query("SELECT * FROM Task WHERE taskId = :taskId")
    Task selectDataFromAnId(int taskId);

    @Query("UPDATE Task SET taskTitle = :taskTitle, taskDescription = :taskDescription, date = :taskDate, time = :taskTime WHERE taskId = :taskId")
    void updateAnExistingRow(int taskId, String taskTitle, String taskDescription, String taskDate, String taskTime);

}
