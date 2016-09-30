package com.example.habittracker2;

import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * Created by carlcastello on 29/09/16.
 */
public class HabitTest extends TestCase {
    private Habit habit;

    public void createHabitTest(){
        String title = "A habit";
        String text = "Habit Description";
        ArrayList occurrences = new ArrayList<String>(){};
        this.habit = new Habit(title,text);

        assertTrue("Title Not Equal", this.habit.getTitle() == title);
        assertTrue("Text Not Equal", this.habit.getText() == text);
        assertTrue("Occurrence Not Equal", this.habit.getOccurrence() == occurrences);
    }

    public void addOccurrencesTest() {

    }

}
