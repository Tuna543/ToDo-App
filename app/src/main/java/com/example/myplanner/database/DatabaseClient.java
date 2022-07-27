package com.example.myplanner.database;

import android.content.Context;

import androidx.room.Room;

public class DatabaseClient {
    private Context mCtx;
    private static DatabaseClient mInstance;

    //our app database object
    private AppDatabase appDatabase;
    
    
     /**This will call the room database
     *
     * @param mCtx
     */

    private DatabaseClient(Context mCtx) {
        this.mCtx = mCtx;
        appDatabase = Room.databaseBuilder(mCtx, AppDatabase.class, "Task.db")
                .fallbackToDestructiveMigration()
                .build();
    }
    
    
     /**This will synchronized with DatabaseClient and return instance
     *
     * @param mCtx
     * @return mInstance
     */


    public static synchronized DatabaseClient getInstance(Context mCtx) {
        if (mInstance == null) {
            mInstance = new DatabaseClient(mCtx);
        }
        return mInstance;
    }

    public AppDatabase getAppDatabase() {
        return appDatabase;
    }
}
