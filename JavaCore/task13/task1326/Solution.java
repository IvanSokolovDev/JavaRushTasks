package com.javarush.task.task13.task1326;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String fileName = input.nextLine();

        List<Integer> numbers = new ArrayList<>();

        try (FileInputStream inputStream = new FileInputStream(fileName)){

            input = new Scanner(inputStream);

            while (input.hasNextInt()) {
                numbers.add(input.nextInt());
            }

            numbers.stream()
                    .sorted()
                    .filter(num -> num % 2 == 0)
                    .forEach(System.out::println);

        } catch (IOException e){
            System.out.println("Ошибка открытия файла");
            e.printStackTrace();
        }
    }
}
