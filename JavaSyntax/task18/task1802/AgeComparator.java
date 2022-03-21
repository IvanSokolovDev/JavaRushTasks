package com.javarush.task.pro.task18.task1802;

import java.util.Comparator;

/* 
Сортировка по возрасту
*/

public class AgeComparator implements Comparator<Student>{
    public int compare(Student first, Student second){
        return second.getAge() - first.getAge();
    }
}
