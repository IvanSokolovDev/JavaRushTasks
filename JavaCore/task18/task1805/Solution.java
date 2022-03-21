package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static String fileName;
    public static List<Integer> numbers;

    static {
        fileName = "";
        numbers = new ArrayList<>();
    }


    public static void main(String[] args) throws Exception {
        fileName = readFileName();
        readBytes(fileName, numbers);
        sort(numbers);
        numbers.forEach(elem -> System.out.printf("%d ", elem));
    }

    public static String readFileName() {
        return new Scanner(System.in).nextLine();
    }

    public static void readBytes(String file, List<Integer> list) {
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            while (fileInputStream.available() > 0) {
                int currentByte = fileInputStream.read();

                if (!list.contains(currentByte)) {
                    list.add(currentByte);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sort(List<Integer> list) {
        list.sort(Integer::compare);
    }
}
