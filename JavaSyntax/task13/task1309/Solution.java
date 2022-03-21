package com.javarush.task.pro.task13.task1309;

import java.util.HashMap;

/* 
Успеваемость студентов
*/

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println(grades);
    }

    public static void addStudents() {
        //напишите тут ваш код
        grades.put("Денчик", 5.0);
        grades.put("Богданчик", 3.2);
        grades.put("Светлана", 2.2);
        grades.put("Глэк", 2.8);
        grades.put("Охумирон", 4.5);
    }
}
