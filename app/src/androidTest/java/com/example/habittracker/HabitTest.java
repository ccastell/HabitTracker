package com.example.habittracker;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by carlcastello on 27/09/16.
 */
public class HabitTest extends TestCase {
    private Habit habit;
    protected String title;
    protected String text;
    protected ArrayList<String> repeat;
    protected String title2;
    public void testHabit() {
        title = "A habit";
        //title2 = "A habi2t";
        this.text = "Habit Description";
        this.repeat = new ArrayList<String>();
        this.habit = new Habit(this.title,this.text,this.repeat);
        assertTrue(habit.checkEverything(this.title,this.text,this.repeat));


        Date date1 = new Date();
        this.habit.addDate(date1);
        Date date = new Date();
        assertTrue(this.habit.checkappendDate(date));

        this.repeat.add("Monday");
        //this.habit.changeOccurrence(this.repeat);
        assertTrue(this.habit.checkchangeOccurence(this.repeat));
    }

}
