package com.javarush.task.pro.task09.task0914;

/* 
Обновление пути
*/

public class Solution {
    public static void main(String[] args) {
        String path = "/usr/java/jdk1.8/bin/";

        String jdk13 = "jdk-13";
        System.out.println(changePath(path, jdk13));
    }

    public static String changePath(String path, String jdk) {
        //напишите тут ваш код
        int firstIndex = path.indexOf("jdk");
        int secondIndex = path.indexOf("/", firstIndex);
        String result;
        result = path.substring(firstIndex, secondIndex);
        result = path.replace(result, jdk);
        return result;
    }
}
