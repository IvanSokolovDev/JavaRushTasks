package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* 
Самые редкие байты
*/

public class Solution {
//    public static String fileName;
//    public static Map<Integer, Integer> numberCount;
//    public static int count;

//    static {
//        fileName = "";
//        numberCount = new HashMap<>();
//        count = 0;
//    }

    public static void main(String[] args) throws Exception {
        String fileName = "";
        Map<Integer, Integer> numberCount = new HashMap<>();
        int count;

        fileName = readFileName();
        readBytes(fileName, numberCount);
        count = minCountByte(numberCount);

        //System.out.println(numberCount.entrySet());

        for (Map.Entry<Integer, Integer> elem : numberCount.entrySet()) {
            if (elem.getValue().equals(count)) {
                System.out.printf("%d ", elem.getKey());
            }
        }
    }

    public static String readFileName() {
        return new Scanner(System.in).nextLine();
    }

    public static void readBytes(String file, Map<Integer, Integer> map) {
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            while (fileInputStream.available() > 0) {
                int currentByte = fileInputStream.read();

                if (!map.containsKey(currentByte)) {
                    map.put(currentByte, 1);
                } else {
                    map.put(currentByte, map.get(currentByte) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int minCountByte(Map<Integer, Integer> map) {
        return map.values().stream().min(Integer::compare).get();
    }
}
