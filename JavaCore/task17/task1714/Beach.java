package com.javarush.task.task17.task1714;

/* 
Comparable
*/


public class Beach implements Comparable<Beach>{
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    @Override
    public synchronized int compareTo(Beach beach) {
        int beach1 = 0;
        int beach2 = 0;

        float distance = this.distance - beach.getDistance();

        if (distance < 0) {
            beach1++;
        } else if (distance > 0) {
            beach2++;
        }

        int quality = this.quality - beach.getQuality();

        if (quality > 0) {
            beach1++;
        } else if (quality < 0) {
            beach2++;
        }

        return beach1 - beach2;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {
        Beach beach1 = new Beach("ХУЙ", 200, 654);
        Beach beach2 = new Beach("ПИЗДА", 5000, 5);
        System.out.println(beach1.compareTo(beach2));
    }
}
