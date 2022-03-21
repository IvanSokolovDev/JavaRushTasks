package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static String fileName1 = "";
    public static String fileName2 = "";

    public static void main(String[] args) throws CorruptedDataException {
        fileName1 = readFileName();
        fileName2 = readFileName();

        readFileLines(fileName1, allLines);
        readFileLines(fileName2, forRemoveLines);

        System.out.println(allLines);
        System.out.println(forRemoveLines);

        new Solution().joinData();
    }

    public static String readFileName() {
        return new Scanner(System.in).nextLine();
    }

    public static void readFileLines(String fileName, List<String> lines) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                lines.add(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
