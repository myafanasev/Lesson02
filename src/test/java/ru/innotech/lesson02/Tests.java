package ru.innotech.lesson02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class Tests {
    @Test
    @DisplayName("Проверка на пустое имя владельца счета")
    public void testNameNull() {
        //throw new AssertionFailedError("Тест неудачен");
        //Assertions.assertEquals(5, 5);
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Account(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Account(""));

        Account account = new Account("Михаил");
        Assertions.assertThrows(IllegalArgumentException.class, () -> account.setName(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> account.setName(""));
    }

    @Test
    @DisplayName("Проверка на некорректное значение для пар валюта-количество")
    public void testCurrencyValue() {
        Account account = new Account("Михаил");
        Assertions.assertThrows(IllegalArgumentException.class, () -> account.addMoneys(Currency.RUB, null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> account.addMoneys(Currency.RUB, -500));
    }

    @Test
    @DisplayName("Проверка на инкапсуляцию для пар валюта-количество")
    public void testCurrencyEncapsulation() {
        Account account = new Account("Михаил");
        account.addMoneys(Currency.RUB, 100);
        Map<Currency, Integer> m = account.getMoneys();
        m.put(Currency.RUB, 200); // изменим значение для валюты
        Assertions.assertNotEquals(account.getMoneys(), m);
    }

    @Test
    @DisplayName("Проверка корректности выполнения отмены")
    public void testUndo() {
        Account account = new Account("Михаил");
        account.addMoneys(Currency.RUB, 100);
        account.setName("Василий");
        account.addMoneys(Currency.RUB, 300);

        account.undo();
        Assertions.assertEquals(account.getMoneys().get(Currency.RUB), 100);
        account.undo();
        Assertions.assertEquals(account.getName(), "Михаил");
        account.undo();
        Assertions.assertEquals(account.getMoneys().get(Currency.RUB), null);
        // попытка откатить изменения, которых не было
        Assertions.assertThrows(NullPointerException.class, () -> account.undo());
    }

    @Test
    @DisplayName("Проверка корректности сохранения и восстановления")
    public void testSave() {
        Account account = new Account("Михаил");
        account.addMoneys(Currency.RUB, 100);
        Map<Currency, Integer> m1 = account.getMoneys();
        Saveable save1 = account.save();

        account.setName("Григорий");
        account.addMoneys(Currency.EUR, 200);
        account.addMoneys(Currency.RUB, 300);
        Map<Currency, Integer> m2 = account.getMoneys();
        Saveable save2 = account.save();

        account.setName("Илья");
        account.addMoneys(Currency.USD, 500);

        save1.load();
        Assertions.assertEquals(account.getName(), "Михаил");
        Assertions.assertEquals(account.getMoneys(), m1);

        save2.load();
        Assertions.assertEquals(account.getName(), "Григорий");
        Assertions.assertEquals(account.getMoneys(), m2);
    }
}
