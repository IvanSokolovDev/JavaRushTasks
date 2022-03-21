package com.javarush.task.pro.task15.task1511;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Пишем символы в файл
*/

public class Solution {
    public static void main(String[] args) {
        char[] chars = args[0].toCharArray();

        Scanner scanner = null;
        BufferedWriter bufferedWriter = null;
        try {
            scanner = new Scanner(System.in);
            Path path = Path.of(scanner.nextLine());
            bufferedWriter = Files.newBufferedWriter(path);
            bufferedWriter.write(chars);
        } catch (IOException e) {
            System.out.println("Something went wrong : " + e);
        }
        finally {
            try {
                scanner.close();
                if (bufferedWriter != null){
                    bufferedWriter.close();
                }
            }
            catch (Exception e){
                System.out.println("Невозможно закрыть поток");
            }
        }
    }
}


