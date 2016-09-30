package com.example.habittracker2;

import java.util.ArrayList;

/**
 * Created by carlcastello on 29/09/16.
 */
public class HabitList {
    private ArrayList<Habit> habitlist;

    public HabitList (){
        this.habitlist = new ArrayList<Habit>();
    }


    public void addHabit(Habit habit){
        this.habitlist.add(habit);
    }

    public Habit getHabit(int index) {
        return this.habitlist.get(index);
    }

    public void removeHabit(Habit habit){
        this.habitlist.remove(habit);
    }

    public ArrayList<Habit> getHabitlist() {
        return this.habitlist;
    }

    public void recoverHabitlist(ArrayList<Habit> habitlist){
        this.habitlist = habitlist;
    }

    public int countHabit(){
        return habitlist.size();
    }


}
