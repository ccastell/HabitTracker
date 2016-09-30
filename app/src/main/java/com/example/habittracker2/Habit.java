package com.example.habittracker2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by carlcastello on 29/09/16.
 */
public class Habit {
    private String title;
    private String text;
    private ArrayList<Date> history;
    private ArrayList<String> occurrences;

    public Habit(String title, String text){
        //Date date = date;
        this.title = title;
        this.text = text;
        this.history = new ArrayList<Date>();
        this.occurrences = new ArrayList<String>();
    }

    public void addHistory() {
        Date date = new Date();
        this.history.add(date);
    }

    public void addOccurrences(ArrayList<String> occurrences) {
        this.occurrences = occurrences;
    }

    //public String getCreationDate(){
    //    String creationDate = dateFormat.format(this.history.get(0));
    //    return creationDate;
    //}

    public ArrayList<Date> getHistory(){
        return this.history;
    }

    public ArrayList<String> getOccurences(){
        return this.occurrences;
    }

    @Override
    public String toString() {
        String habitTitle = this.getTitle();
        //String creationDate = this.getCreationDate();
        return habitTitle;
    }

    //Test Case Conditions
    public String getTitle() {
        return this.title;
    }
    public String getText() {
        return this.text;
    }
    public ArrayList getOccurrence() {
        return this.occurrences;
    }
}
