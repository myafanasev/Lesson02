package ru.innotech.lesson02;

import java.util.HashMap;
import java.util.Map;

public class Starter {
    public static void main(String[] args) {
        Account account = new Account("Петров Василий");
        account.addMoneys(Currency.RUB, 1000);
        account.addMoneys(Currency.CNY, 230);
        account.addMoneys(Currency.CNY, 500);
        System.out.println(account);

        //Account account1 = new Account(null);
        System.out.println("привет");


    }
}
