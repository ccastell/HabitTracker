package com.example.habittracker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Created by carlcastello on 26/09/16.
 */
public class HabitList {
    protected ArrayList<Habit> habitList;

    public void HabbitList() {
        this.habitList = new ArrayList<Habit>();
    }

    public Collection<Habit> getHabit() {
        return this.habitList;
    }

    public void addHabit (Habit newhabit) {
        this.habitList.add(newhabit);
    }

    public void removehabit (Habit oldhabit) {
        this.habitList.remove(oldhabit);
    }

}

