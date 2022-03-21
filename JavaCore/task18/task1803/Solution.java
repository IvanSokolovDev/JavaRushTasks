package com.javarush.task.task18.task1803;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/* 
Самые частые байты
*/

public class Solution {
    public static String fileName;
    public static Map<Integer, Integer> numberCount;
    public static int count;

    static {
        fileName = "";
        numberCount = new HashMap<>();
        count = 0;
    }

    public static void main(String[] args) throws Exception {
        fileName = readFileName();
        readBytes(fileName, numberCount);
        count = maxCountByte(numberCount);

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

    public static int maxCountByte(Map<Integer, Integer> map) {
        return map.values().stream().max(Integer::compare).get();
    }
}
