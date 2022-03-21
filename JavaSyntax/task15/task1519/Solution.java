package com.javarush.task.pro.task15.task1519;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.Scanner;

/* 
Поверхностное копирование
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Path sourceDirectory = Path.of(scanner.nextLine());
        Path targetDirectory = Path.of(scanner.nextLine());
        //напишите тут ваш код
        try (DirectoryStream<Path> directoryStreamSource = Files.newDirectoryStream(sourceDirectory);){
            for (Path files : directoryStreamSource){
                if (Files.isRegularFile(files)) {
                    if (Files.notExists(targetDirectory.resolve(files.getFileName()))) {
                        Files.copy(files, targetDirectory.resolve(files.getFileName()));
                    }
                }
            }
        }
    }
}


