package com.javarush.task.task14.task1408;

/* 
Куриная фабрика
*/

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Country.BELARUS);
        System.out.println(hen.getDescription());
    }

    static class HenFactory {

        static Hen getHen(String country) {
            if (country.equals(Country.BELARUS)){
                return new BelarusianHen();
            } else if (country.equals(Country.MOLDOVA)) {
                return new MoldovanHen();
            } else if (country.equals(Country.RUSSIA)) {
                return new RussianHen();
            } else if (country.equals(Country.UKRAINE)) {
                return new UkrainianHen();
            }

            return null;
        }
    }


}
