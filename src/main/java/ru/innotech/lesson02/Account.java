package ru.innotech.lesson02;

import java.util.HashMap;
import java.util.Map;

public class Account {
    private String name;
    private Map<Currency, Integer> moneys = new HashMap<>();

    public Account(String name) {
        if (name == "" || name == null) throw new IllegalArgumentException("имя такое");
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Map<Currency, Integer> getMoneys() {
        return moneys;
    }

    public void addMoneys(Currency currency, Integer value) {
        moneys.put(currency, value);
    }

    @Override
    public String toString() {
        return "Владелец счета: " + name + ", денежные средства: " + moneys;
    }
}
