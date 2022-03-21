package com.javarush.task.task18.task1809;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Реверс файла
*/

public class Solution {
    public static String fromFile;
    public static String toFile;

    static {
        fromFile = "C:\\Users\\Admin\\Documents\\text1.txt";
        toFile = "C:\\Users\\Admin\\Documents\\text2.txt";
    }

    public static void main(String[] args) {
//        fromFile = readFileName();
//        toFile = readFileName();

        reverse(fromFile, toFile);
    }

    public static String readFileName() {
        return new Scanner(System.in).nextLine();
    }

    public static void reverse(String from, String to) {
        try (FileInputStream fileInputStream = new FileInputStream(from);
             FileOutputStream fileOutputStream = new FileOutputStream(to)) {

            ArrayList<Integer> bytes = new ArrayList<>();

            while (fileInputStream.available() > 0) {
                bytes.add(fileInputStream.read());
            }

            for (int i = bytes.size() - 1; i >= 0; i--) {
                fileOutputStream.write(bytes.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
