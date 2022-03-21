package com.javarush.task.task18.task1807;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/* 
Подсчет запятых
*/

public class Solution {
    public static String fileName;

    static {
        fileName = "";
    }

    public static void main(String[] args) {
        fileName = readFileName();
        System.out.println(countSeparator(fileName));
    }

    public static String readFileName() {
        return new Scanner(System.in).nextLine();
    }

    public static int countSeparator(String file) {
        int count = 0;

        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            if (fileInputStream.available() > 0) {
                int availableBytes = fileInputStream.available();
                byte[] bytes = new byte[availableBytes];
                int countBytes = fileInputStream.read(bytes);

                for (byte elem : bytes) {
                    if ((char) elem == ',') {
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return count;
    }
}
