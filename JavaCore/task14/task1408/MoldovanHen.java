package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen{
    public String country = Country.MOLDOVA;

    @Override
    public int getCountOfEggsPerMonth() {
        return 1500;
    }

    @Override
    public String getDescription() {

        return super.getDescription() + String.format(" Моя страна - %s. Я несу %d яиц в месяц.",
                country, getCountOfEggsPerMonth());
    }
}
