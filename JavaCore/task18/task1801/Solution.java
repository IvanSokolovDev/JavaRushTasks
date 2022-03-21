package com.javarush.task.task18.task1801;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Максимальный байт
*/

public class Solution {
    public static String fileName;
    public static List<Integer> bytes = new ArrayList<>();

    static {
        fileName = "C:\\Users\\Admin\\Documents\\text1.txt";
    }

    public static void main(String[] args) throws Exception {
        fileName = readFileName();
        System.out.println(maxByte(fileName));
    }

    public static String readFileName() {
        return new Scanner(System.in).nextLine();
    }

    public static int maxByte(String file) {
        try (FileInputStream inputStream = new FileInputStream(file)) {
            while (inputStream.available() > 0) {
                bytes.add(inputStream.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bytes.stream().max(Integer::compare).get();
    }
}
