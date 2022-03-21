package com.javarush.task.pro.task16.task1607;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* 
Освоение нового API
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(nowExample());
        System.out.println(ofExample());
        System.out.println(ofYearDayExample());
        System.out.println(ofEpochDayExample());
    }

    static LocalDate nowExample() {
        return LocalDate.now();
    }

    static LocalDate ofExample() {
        return LocalDate.of(2020, 9, 12);
    }

    static LocalDate ofYearDayExample() {
        Calendar calendar = new GregorianCalendar(2020, 8, 12);
        return LocalDate.ofYearDay(2020, calendar.get(Calendar.DAY_OF_YEAR));
    }

    static LocalDate ofEpochDayExample() {
        return LocalDate.ofEpochDay(ofExample().toEpochDay());
    }
}
