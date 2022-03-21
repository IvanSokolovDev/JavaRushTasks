package com.javarush.task.pro.task16.task1612;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

/* 
Синтезируем LocalDateTime
*/

public class Solution {

    public static void main(String[] args) {
        Map<LocalDate, List<LocalTime>> dateMap = DateTimeGenerator.generateDateMap();
        printCollection(dateMap.entrySet());

        Set<LocalDateTime> dateSet = convert(dateMap);
        printCollection(dateSet);
    }

    static Set<LocalDateTime> convert(Map<LocalDate, List<LocalTime>> sourceMap) {
        //напишите тут ваш код
//        Set<LocalDateTime> localDateTimeSet = new HashSet<>();
//
//        Set<LocalDate> keys = sourceMap.keySet();
//
//        for (LocalDate elemDate : keys){
//            for (LocalTime time : sourceMap.get(elemDate)){
//                int year = elemDate.getYear();
//                int month = elemDate.getMonthValue();
//                int day = elemDate.getDayOfMonth();
//
//                int hour = time.getHour();
//                int minute = time.getMinute();
//                int second = time.getSecond();
//                int nano = time.getNano();
//
//                localDateTimeSet.add(LocalDateTime.of(year, month, day, hour, minute, second, nano));
//            }
//        }
//
//        return localDateTimeSet;
        Set<LocalDateTime> localDateTimeSet = new HashSet<>();

        for (Map.Entry<LocalDate, List<LocalTime>> dateTime : sourceMap.entrySet()) {
            for (LocalTime time : dateTime.getValue()){
                localDateTimeSet.add(LocalDateTime.of(dateTime.getKey(), time));
            }
        }

        return localDateTimeSet;
    }

    static void printCollection(Collection<?> collection) {
        System.out.println("-----------------------------------------------------");
        collection.forEach(System.out::println);
    }
}