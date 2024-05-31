package ru.innotech.lesson02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.opentest4j.AssertionFailedError;

public class Tests {
    @Test
    @DisplayName("Проверка значений")
//    @RepeatedTest(value = 4, name = "Имя теста")
//    @ParameterizedTest(name = "Имя теста")
//    @MethodSource("ru.innotech.lesson02.имя_класса#имя_метода")
    public void test01(){
        //throw new AssertionFailedError("Тест неудачен");
        Assertions.assertEquals(5, 5);


    }
}
