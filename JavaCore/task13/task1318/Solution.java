package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader readFileName = new BufferedReader(new InputStreamReader(System.in))){
            String fileName = readFileName.readLine();

            try (FileInputStream readFile = new FileInputStream(fileName)){
                while (readFile.available() > 0) {
                    System.out.print((char) readFile.read());
                }
            }
        } catch (IOException e) {
            System.out.println("BAN");
        }
    }
}