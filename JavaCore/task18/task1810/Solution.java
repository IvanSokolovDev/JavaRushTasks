package com.javarush.task.task18.task1810;

import java.io.*;
import java.util.Scanner;

/* 
DownloadException
*/

public class Solution {
    public static String fileName;

    static {
        fileName = "C:\\Users\\Admin\\Documents\\text1.txt";
    }

    public static void main(String[] args) throws DownloadException {
        FileInputStream fileInputStream;

        while (true) {
            fileName = readFileName();

            try {
                fileInputStream = new FileInputStream(fileName);
                if (fileInputStream.available() < 1000) {
                    throw new DownloadException();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static class DownloadException extends Exception {

    }

    public static String readFileName() {
        return new Scanner(System.in).nextLine();
    }
}
