package com.javarush.task.task19.task1913;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Выводим только цифры
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream surrogate = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);

        System.setOut(printStream);

        testString.printSomething();

        System.setOut(surrogate);

        String string = byteArrayOutputStream.toString();
        String result = "";

        for (int i = 0; i < string.length(); i++) {
            char currentChar = string.charAt(i);

            if (currentChar >= '0' & currentChar <= '9') {
                result = result.concat(Character.toString(currentChar));
            }
        }

        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
