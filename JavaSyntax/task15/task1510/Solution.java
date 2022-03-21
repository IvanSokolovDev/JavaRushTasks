package com.javarush.task.pro.task15.task1510;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Пишем байты в файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        byte[] bytes = args[0].getBytes();
        InputStream inputStream = null;
        Scanner scanner = null;
        try {
            inputStream = System.in;
            scanner = new Scanner(inputStream);
            Path path = Path.of(scanner.nextLine());
            Files.write(path, bytes);
        } catch (IOException e) {
            System.out.println("Something went wrong : " + e);
        }
        finally {
            try {
                if (inputStream != null){
                    inputStream.close();
                }
                if (scanner != null){
                    scanner.close();
                }
            }
            catch (IOException e){
                System.out.println("ERROR");
            }
        }
    }
}

