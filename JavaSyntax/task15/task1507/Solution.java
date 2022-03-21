package com.javarush.task.pro.task15.task1507;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

/* 
Пропускаем не всех
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        List<String> linesFile = Files.readAllLines(Path.of(scanner.nextLine()));

        for (int i = 0; i < linesFile.size(); i = i + 2){
            System.out.println(linesFile.get(i));
        }
    }
}

