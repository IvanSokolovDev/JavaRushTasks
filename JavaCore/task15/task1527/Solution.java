package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();

        url = url.substring(url.indexOf("?") + 1);
        String[] substringArray = url.split("&");

        List<String> stringList = Arrays.asList(substringArray);

        stringList = delete(stringList);
        stringList.forEach(elem -> System.out.printf("%s ", elem));

        System.out.println("\r");
        value(substringArray);

    }

    public static List<String> delete(List<String> stringList) {
        List<String> out = new ArrayList<>();

        for (String elem : stringList) {
            if (elem.contains("=")) {
                out.add(elem.substring(0, elem.indexOf("=")));
            } else {
                out.add(elem);
            }
        }

        return out;
    }

    public static void value(String[] substringArray) {
        for (String elem : substringArray) {
            if (elem.contains("obj")) {
                String temp = elem.substring(elem.indexOf("=") + 1);

                try {
                    double value = Double.parseDouble(temp);
                    alert(value);
                } catch (Exception e) {
                    alert(temp);
                }
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
