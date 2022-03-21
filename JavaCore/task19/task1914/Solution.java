package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Решаем пример
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


        String input = byteArrayOutputStream.toString().replaceAll("\r\n", "");
        String[] strings = input.split(" ");
        int firstTerm = Integer.parseInt(strings[0]);
        int secondTerm = Integer.parseInt(strings[2]);

        if (strings[1].equals("+")) {
            String sum = Integer.toString(firstTerm + secondTerm);
            input = input.concat(sum);
        } else if (strings[1].equals("-")) {
            String difference = Integer.toString(firstTerm - secondTerm);
            input = input.concat(difference);
        } else if (strings[1].equals("*")) {
            String multi = Integer.toString(firstTerm * secondTerm);
            input = input.concat(multi);
        }

        System.out.println(input);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

