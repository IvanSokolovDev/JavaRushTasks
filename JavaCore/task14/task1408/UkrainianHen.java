package com.javarush.task.task14.task1408;

public class UkrainianHen extends Hen {
    public String country = Country.UKRAINE;

    @Override
    public int getCountOfEggsPerMonth() {
        return 0;
    }

    @Override
    public String getDescription() {

        return super.getDescription() + String.format(" Моя страна - %s. Я несу %d яиц в месяц.",
                country, getCountOfEggsPerMonth());

    }
}
