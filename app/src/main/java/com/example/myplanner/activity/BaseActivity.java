package com.example.myplanner.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


/**
 * This is BaseActivity class of MyPlanner application
 * MainActivity will extend this class
 * BaseActivity class
 *
 */

public class BaseActivity extends AppCompatActivity {
    
    /**onCreate
     *
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }


}
