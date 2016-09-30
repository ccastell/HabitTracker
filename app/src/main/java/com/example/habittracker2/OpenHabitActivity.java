package com.example.habittracker2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class OpenHabitActivity extends AppCompatActivity {

    private String titleText;
    private String bodyText;
    private Habit habit;
    private HabitList habitList = new HabitList();
    private ArrayList<Habit> jsonList;
    private static final String FILENAME = "file.sav";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.open_habit);
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadFromFile();
        this.habitList.recoverHabitlist(this.jsonList);
        //if (this.habitList.countHabit() == 0){
        //    finish();
        //}
        int index = getIntent().getIntExtra("Position", 0);
        this.habit = this.habitList.getHabit(index);
    }

    private void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();

            // Code from http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
            Type listType = new TypeToken<ArrayList<Habit>>(){}.getType();
            this.jsonList = gson.fromJson(in,listType);
            //this.habitList.recoverHabitlist(jsonList);

        } catch (FileNotFoundException e) {
			/* Create a brand new tweet list if we can't find the file. */
            this.habitList = new HabitList();
        }
    }
}
