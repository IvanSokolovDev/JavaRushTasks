package com.javarush.task.task14.task1408;

public class BelarusianHen extends Hen {
    public String country = Country.BELARUS;

    @Override
    public int getCountOfEggsPerMonth() {
        return 1000;
    }

    @Override
    public String getDescription() {

        return super.getDescription() + String.format(" Моя страна - %s. Я несу %d яиц в месяц.",
                country, getCountOfEggsPerMonth());
    }
}
