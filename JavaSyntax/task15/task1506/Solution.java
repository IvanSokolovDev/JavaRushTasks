package com.javarush.task.pro.task15.task1506;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

/* 
Фейсконтроль
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Path path = Path.of(scanner.nextLine());

        try {
            List<String> lines = Files.readAllLines(path);
            StringBuilder stringBuilder = new StringBuilder(lines.get(0));

            for (int i = 0; i < stringBuilder.length(); i++){
                if (stringBuilder.charAt(i) == '.' || stringBuilder.charAt(i) == ',' || stringBuilder.charAt(i) == ' '){
                    stringBuilder.deleteCharAt(i);
                    i--;
                }
            }

            System.out.println(stringBuilder);
        }
        catch (Exception e){
            System.out.println("ERROR");
        }
    }
}

