package ru.innotech.lesson02;

import java.util.HashMap;
import java.util.Map;

public class Starter {
    public static void main(String[] args) {
        Account account1 = new Account("Антон");
        account1.addMoneys(Currency.EUR, 800);
        account1.addMoneys(Currency.RUB, 500);
        account1.addMoneys(Currency.RUB, 600);
        Saveable save1 = account1.save();
        System.out.println(account1);
        System.out.println("Выполнили первое сохранение");

        account1.setName("Илья");
        account1.addMoneys(Currency.USD, 100);
        Saveable save2 = account1.save();
        System.out.println(account1);
        System.out.println("Выполнили второе сохранение");

        account1.undo();
        System.out.println("Выполнили откат:");
        System.out.println(account1);

        account1.undo();
        System.out.println("Выполнили откат:");
        System.out.println(account1);

        account1.undo();
        System.out.println("Выполнили откат:");
        System.out.println(account1);

        account1.undo();
        System.out.println("Выполнили откат:");
        System.out.println(account1);

        account1.undo();
        System.out.println("Выполнили откат:");
        System.out.println(account1);

        save1.load();
        System.out.println("Востановление до первого сохранения:");
        System.out.println(account1);

        save2.load();
        System.out.println("Востановление до второго сохранения:");
        System.out.println(account1);
    }
}
