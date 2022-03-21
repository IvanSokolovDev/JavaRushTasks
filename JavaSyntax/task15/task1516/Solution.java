package com.javarush.task.pro.task15.task1516;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Файл или директория
*/

public class Solution {
    private static final String THIS_IS_FILE = " - это файл";
    private static final String THIS_IS_DIR = " - это директория";

    public static void main(String[] args) {
        //напишите тут ваш код
        while(true){
            Scanner scanner = new Scanner(System.in);
            String inputPath = scanner.nextLine();

            if (inputPath.isEmpty()){
                break;
            }
            if (Files.isRegularFile(Path.of(inputPath))){
                System.out.println(inputPath + THIS_IS_FILE);
            }
            else if (Files.isDirectory(Path.of(inputPath))){
                System.out.println(inputPath + THIS_IS_DIR);
            }
            else{
                break;
            }
        }
    }
}

