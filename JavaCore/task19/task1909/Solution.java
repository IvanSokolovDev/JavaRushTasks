package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;

/* 
Замена знаков
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

        String text = "";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName1))) {
            while (bufferedReader.ready()) {
                text = text.concat(bufferedReader.readLine()).concat("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        text = text.replaceAll("\\.", "!");

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName2))) {
            bufferedWriter.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
