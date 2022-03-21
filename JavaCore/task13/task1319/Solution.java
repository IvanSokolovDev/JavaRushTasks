package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.Scanner;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            String fileName = input.nextLine();

            try (BufferedWriter writeInFile = new BufferedWriter(new FileWriter(fileName, true))) {

                String inputString = "";

                while (!inputString.equals("exit")) {
                    inputString = input.nextLine();
                    writeInFile.write(inputString);
                    writeInFile.newLine();
                }
            } catch (Exception e){
                System.out.println("Ошибка записи в файл");
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("Ошибка считывания имени файла");
            e.printStackTrace();
        }
    }
}
