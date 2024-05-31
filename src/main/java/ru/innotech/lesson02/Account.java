package ru.innotech.lesson02;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Account {
    private String name;
    private Map<Currency, Integer> moneys = new HashMap<>();

    public Account(String name) {
        if (name == "" || name == null) throw new IllegalArgumentException("Имя владельца счета не может быть пустым!");
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Map<Currency, Integer> getMoneys() {
        return new HashMap<>(moneys);
    }

    public void addMoneys(Currency currency, Integer value) {
        if (value < 0) throw new IllegalArgumentException("Количество валюты не может быть отрицательным");
        moneys.put(currency, value);
    }

    @Override
    public String toString() {
        return "Владелец счета: " + name + ", денежные средства: " + moneys;
    }
}
