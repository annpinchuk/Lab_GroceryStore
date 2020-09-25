package com.groceryshop;

import java.util.ArrayList;

public class Shop {
    private String name;
    private Cashbox cash;
    private ArrayList<Counter> counters;
    private ArrayList<Worker> workers;

    public Shop(String name, float max_cash) {
        this.name = name;
        this.cash = new Cashbox(max_cash);
        this.counters = new ArrayList<>();
        this.workers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Counter> getCounters() {
        return counters;
    }

    public ArrayList<Worker> getWorkers() {
        return workers;
    }

    public Cashbox getCash() {
        return cash;
    }

    public float getCashMax(){
        return cash.maxCash;
    }

    public void addCounter(Counter counter){
        this.counters.add(counter);
    }

    public void addWorker(Worker worker){
        this.workers.add(worker);
    }

    private static class Cashbox {
        float maxCash;
        private float current_balance = 0;

        public Cashbox(float maxCash) {
            this.maxCash = maxCash;
        }

    }
}
