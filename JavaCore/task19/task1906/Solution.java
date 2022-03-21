package com.javarush.task.task19.task1906;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName1;
        String fileName2;

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName1 = bufferedReader.readLine();
            fileName2 = bufferedReader.readLine();
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        try (FileReader fileReader = new FileReader(fileName1)) {
            while (fileReader.ready()) {
                list.add(fileReader.read());
            }
        }

        try (FileWriter fileWriter = new FileWriter(fileName2)) {
            for (int i = 1; i < list.size(); i = i + 2) {
                fileWriter.write((byte) (int) list.get(i));
            }
        }
    }
}

//public class Solution {
//    public static String fileNameInput;
//    public static String fileNameOutput;
//
//    static {
//        fileNameInput = "C:\\Users\\Admin\\Documents\\text1.txt";
//        fileNameOutput = "C:\\Users\\Admin\\Documents\\text2.txt";
//    }
//
//
//    public static void main(String[] args) {
////        fileNameInput = readFileName();
////        fileNameOutput = readFileName();
//        String string = readFile(fileNameInput);
//        char[] chars = evenIndex(string);
//        printEvenIndex(fileNameOutput, chars);
//    }
//
//    public static String readFileName() {
//
//        try {
//            return new BufferedReader(new InputStreamReader(System.in)).readLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//
//    public static String readFile(String file) {
//        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
//            return bufferedReader.readLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//
//    public static char[] evenIndex(String chars) {
//        char[] out = new char[chars.length()];
//        int currentIndex = 0;
//
//        for (int i = 0; i < chars.length(); i++) {
//            if (i % 2 == 1) {
//                out[currentIndex] = chars.charAt(i);
//                currentIndex++;
//            }
//        }
//
//        return out;
//    }
//
//    public static void printEvenIndex(String file, char[] array) {
//        try (FileWriter writer = new FileWriter(file)) {
//            writer.write(array);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
