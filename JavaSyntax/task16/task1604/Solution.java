package com.javarush.task.pro.task16.task1604;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

/* 
День недели рождения твоего
*/

public class Solution {

    static Calendar birthDate = new GregorianCalendar(2002, 5, 7);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Calendar calendar) {
        HashMap<Integer, String> dayOfWeeks = new HashMap<>(){{
            put(1, "воскресенье");
            put(2, "понедельник");
            put(3, "вторник");
            put(4, "среда");
            put(5, "четверг");
            put(6, "пятница");
            put(7, "суббота");
        }};

        return dayOfWeeks.get(calendar.get(Calendar.DAY_OF_WEEK));
    }
}
