package com.example.habittracker2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

public class AddHabitActivity extends AppCompatActivity {
    private Habit newHabit;
    private EditText titleText;
    private EditText bodyText;
    private ArrayList<String> occurrences;

    private HabitList habitList = new HabitList();
    private static final String FILENAME = "file.sav";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_habit);

        this.titleText = (EditText) findViewById(R.id.AddPage_title);
        this.bodyText = (EditText) findViewById(R.id.AddPage_description);
        this.occurrences = new ArrayList<String>();


        Button doneButton = (Button) findViewById(R.id.AddPage_done_button);
        doneButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        // TODO Auto-generated method stuff

                        String title = titleText.getText().toString();
                        String body = bodyText.getText().toString();

                        newHabit = new Habit(title,body);
                        newHabit.addHistory();
                        newHabit.addOccurrences(occurrences);

                        habitList.addHabit(newHabit);

                        if (habitList.countHabit() != 0) {
                            saveInFile();
                            setResult(RESULT_OK);
                            finish();
                        }
                    }
                }
        );
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadFromFile();
    }

    //Check Box onClick
    //https://developer.android.com/reference/android/widget/CheckBox.html
    public void AddPage_onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        String day;
        switch(view.getId()) {
            case R.id.AddPage_sunday:
                day = "Sunday";
                if (checked) {
                    this.occurrences.add(day);
                }
                else {
                    if (this.occurrences.contains(day)) {
                        this.occurrences.remove(day);
                    }
                }
                break;

            case R.id.AddPage_monday:
                day = "Monday";
                if (checked) {
                    this.occurrences.add(day);
                }
                else {
                    if (this.occurrences.contains(day)) {
                        this.occurrences.remove(day);
                    }
                }
                break;

            case R.id.AddPage_tuesday:
                day = "Tuesday";
                if (checked) {
                    this.occurrences.add(day);
                }
                else {
                    if (this.occurrences.contains(day)) {
                        this.occurrences.remove(day);
                    }
                }
                break;

            case R.id.AddPage_wednesday:
                day = "Wednesday";
                if (checked) {
                    this.occurrences.add(day);
                }
                else {
                    if (this.occurrences.contains(day)) {
                        this.occurrences.remove(day);
                    }
                }
                break;

            case R.id.AddPage_thursday:
                day = "Thursday";
                if (checked) {
                    this.occurrences.add(day);
                }
                else {
                    if (this.occurrences.contains(day)) {
                        this.occurrences.remove(day);
                    }
                }
                break;

            case R.id.AddPage_friday:
                day = "Friday";
                if (checked) {
                    this.occurrences.add(day);
                }
                else {
                    if (this.occurrences.contains(day)) {
                        this.occurrences.remove(day);
                    }
                }
                break;

            case R.id.AddPage_saturday:
                day = "Saturday";
                if (checked) {
                    this.occurrences.add(day);
                }
                else {
                    if (this.occurrences.contains(day)) {
                        this.occurrences.remove(day);
                    }
                }
                break;

        }
    }


    //This will save the data into a file
    private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME,0);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

            Gson gson = new Gson();
            gson.toJson(habitList.getHabitlist(), out);
            out.flush();

            fos.close();
        } catch (FileNotFoundException e) {
			/* Rethrow. */
            throw new RuntimeException(e);
        } catch (IOException e) {
			/* Rethrow. */
            throw new RuntimeException(e);
        }
    }

    //This will load the old habitList
    private void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();

            // Code from http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
            Type listType = new TypeToken<ArrayList<Habit>>(){}.getType();
            ArrayList<Habit> jsonList = gson.fromJson(in,listType);
            this.habitList.recoverHabitlist(jsonList);

        } catch (FileNotFoundException e) {
			/* Create a brand new tweet list if we can't find the file. */
            this.habitList = new HabitList();
        }
    }
}
