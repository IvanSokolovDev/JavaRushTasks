package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) {
        String fileName1 = "C:\\Users\\Admin\\Documents\\text1.txt";
        String fileName2 = "C:\\Users\\Admin\\Documents\\text2.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName1 = bufferedReader.readLine();
            fileName2 = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName1));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName2))) {

            StringBuilder stringBuilder = new StringBuilder();

            while (bufferedReader.ready()) {
                stringBuilder.append(bufferedReader.readLine()).append(" ");
            }

            String text = stringBuilder.toString();
            StringTokenizer stringTokenizer = new StringTokenizer(text, " ");

            while (stringTokenizer.hasMoreTokens()) {
                String currentToken = stringTokenizer.nextToken();

                try {
                    Integer.parseInt(currentToken);
                } catch (NumberFormatException e) {
                    continue;
                }

                bufferedWriter.write(currentToken + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
