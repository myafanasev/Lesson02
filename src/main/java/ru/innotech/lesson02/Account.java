package ru.innotech.lesson02;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Account {
    private String name;
    private Map<Currency, Integer> moneys = new HashMap<>();

    private HistoryUndo historyUndo = new HistoryUndo();    // список операций для выполнения отмены

    public Account(String name) {
        setName(name);
    }
    public void setName(String name) {
        if (name == "" || name == null) throw new IllegalArgumentException("Имя владельца счета не может быть пустым!");
        if (!historyUndo.isFlagUndo()) { //  при выполнении отмены не нужно добавлять операцию в список для отмены
            if (this.name != null) {    // значит это не первая инициализация
                String currentName = this.name;
                historyUndo.add(h -> h.setName(currentName)); // добавим в список для отмены операцию установки текущего имени владельца
            }
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Map<Currency, Integer> getMoneys() {
        return new HashMap<>(moneys);
    }

    public void addMoneys(Currency currency, Integer value) {

        if (value == null) throw new IllegalArgumentException("Необходимо указать количество валюты");
        if (value < 0) throw new IllegalArgumentException("Количество валюты не может быть отрицательным");

        if (!historyUndo.isFlagUndo()) { //  при выполнении отмены не нужно добавлять операцию в список для отмены
            Integer currentValue = moneys.get(currency);
            if (currentValue == null)   // если для валюты ещё не установлено значение
                historyUndo.add(h -> h.delMoneys(currency));    // добавим в список для отмены метод удаления валюты из списка
            else
                historyUndo.add(h -> h.addMoneys(currency, currentValue));  // добавим в список для отмены метод установки текущего значения валюты
        }
        moneys.put(currency, value);    // установим новое значение
    }

    public void delMoneys(Currency currency) {
        moneys.remove(currency);
    }

    @Override
    public String toString() {
        return "Владелец счета: " + name + ", денежные средства: " + moneys;
    }

    public void undo () {
        historyUndo.setFlagUndo(true); // установим режим выполнения отмены
        historyUndo.get().undoMethod(this);
        historyUndo.setFlagUndo(false); // снимем режим выполнения отмены
    }
}
