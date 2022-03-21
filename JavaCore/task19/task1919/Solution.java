package com.javarush.task.task19.task1919;

import java.io.*;
import java.security.interfaces.DSAPublicKey;
import java.util.*;

/* 
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\Admin\\Documents\\text1.txt";
        fileName = args[0];
        TreeMap<String, Double> fileInfo = new TreeMap<>();
        String textFile = "";

        try (FileReader fileReader = new FileReader(fileName)) {
            while (fileReader.ready()) {
                String currentChar = Character.toString((char) fileReader.read());
                textFile = textFile.concat(currentChar);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> fileStrings = new ArrayList<>();
        char[] textFileChar = textFile.toCharArray();

        try (BufferedReader bufferedReader = new BufferedReader(new CharArrayReader(textFileChar))) {
            while (bufferedReader.ready()) {
                fileStrings.add(bufferedReader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Iterator<String> iterator = fileStrings.listIterator();

        while (iterator.hasNext()) {
            String currentString = iterator.next();
            String surname = currentString.substring(0, currentString.indexOf(" "));
            String salary = currentString.substring(currentString.indexOf(" ") + 1);
            Double salaryValue = Double.parseDouble(salary);

            if (fileInfo.containsKey(surname)) {
                Double newSalaryValue = fileInfo.get(surname) + salaryValue;
                fileInfo.put(surname, newSalaryValue);
            } else {
                fileInfo.put(surname, salaryValue);
            }
        }

        for (String key : fileInfo.keySet()) {
            System.out.println(key + " " + fileInfo.get(key));
        }
    }
}
