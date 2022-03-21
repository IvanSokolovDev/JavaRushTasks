package com.javarush.task.pro.task09.task0916;

/* 
String.format()
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(format("Амиго", 5000));
    }

    public static String format(String name, int salary) {
        String phrase = "Меня зовут . Я буду зарабатывать $ в месяц.";
        //напишите тут ваш код
        String result = null;

        int firstIndex = phrase.indexOf("зовут") + 6;
        String firstStr = phrase.substring(0, firstIndex) + "%s";

        int secondIndex = phrase.indexOf("$") + 1;
        String secondStr = phrase.substring(firstIndex, secondIndex) + "%d";

        //int thirdIndex = phrase.lastIndexOf("$") + 1;
        String thirdStr = phrase.substring(secondIndex);

        result = String.format(firstStr, name) + secondStr;
        result = String.format(result, salary) + "%s";
        result = String.format(result, thirdStr);

        return result;
    }
}
