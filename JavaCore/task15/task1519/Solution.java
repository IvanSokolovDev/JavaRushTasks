package com.javarush.task.task15.task1519;

import javax.security.auth.callback.CallbackHandler;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String input;

        while (!(input = scanner.nextLine()).equals("exit")) {

            try {
                if (input.contains(".")) {
                    print(Double.parseDouble(input));
                } else {
                    int temp = Integer.parseInt(input);

                    if (temp > 0 && temp < 128) {
                        print((short) temp);
                    } else {
                        print(temp);
                    }
                }
            } catch (Exception e) {
                print(input);
            }

        }

    }

    public static boolean isWord(String str) {
        if (str == null || str.isEmpty()) return false;

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isLetter(str.charAt(i))) return false;
        }

        return true;
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
