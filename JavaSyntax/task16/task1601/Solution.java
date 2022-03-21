package com.javarush.task.pro.task16.task1601;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

/* 
Лишь бы не в понедельник :)
*/

public class Solution {

    static Date birthDate = new Date(102, 6, 7);
    public static HashMap<String, String> days = new HashMap<>() {{
        put("пн", "понедельник");
        put("вт", "вторник");
        put("ср", "среда");
        put("чт", "четверг");
        put("пт", "пятница");
        put("сб", "суббота");
        put("вс", "воскресенье");
    }};

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE");
        return days.get(simpleDateFormat.format(birthDate));
    }
}
