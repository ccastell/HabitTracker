package com.example.habittracker;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by carlcastello on 26/09/16.
 */
public class Habit {
    private String title;
    private Integer counter;
    protected String text;
    protected ArrayList<Date> timeline;
    protected ArrayList<String> occurrence;

    //Main Action of the Habit Class
    public Habit(String title, String text, ArrayList<String> repeat) {
        this.title = title;
        this.text = text;
        this.counter = 0;
        this.occurrence = repeat;
        this.timeline = new ArrayList<Date>();
    }

    public void addDate(Date date) {
        this.timeline.add(date);
    }
    public void addCounter() {
        this.counter = this.counter + 1;
    }
    public void changeOccurrence(ArrayList<String> repeat) {
        this.occurrence = repeat;
    }



    //Check Cases Figure this out
    public boolean checkEverything(String title, String text, ArrayList<String> repeat){
        if (this.title == title && this.text == text) {
            if (this.occurrence.equals(repeat)) {
                return true;
            }
        }
        return false;
    }
    public boolean checkappendDate(Date date){
        if (this.timeline.contains(date)) {
            return true;
        }
        return false;
    }
    public boolean checkchangeOccurence(ArrayList<String> repeat) {
        if (this.occurrence.equals(repeat)) {
            return true;
        }
        return false;
    }
}
