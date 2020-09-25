package com.groceryshop;

import java.util.ArrayList;

public class Merchandiser extends Worker{
    private ArrayList<Counter> counters;

    public Merchandiser(String name) {
        super(name);
        this.counters = new ArrayList<>();
    }

    public void addCounter(Counter counter){
        this.counters.add(counter);
    }

    public ArrayList<Counter> getCounters() {
        return counters;
    }
}
