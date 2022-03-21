package com.javarush.task.pro.task17.task1708;

/* 
Минимальное и максимальное
*/

public class MinMaxUtil {
    //напишите тут ваш код
    public static int min(int n1, int n2){
        return Math.min(n1, n2);
    }
    public static int min(int n1, int n2, int n3){
        return min(n1, min(n2, n3));
    }
    public static int min(int n1, int n2, int n3, int n4){
        return min(n1, min(n2, n3, n4));
    }
    public static int min(int n1, int n2, int n3, int n4, int n5){
        return min(n1, min(n2, n3, n4, n5));
    }
    public static int max(int n1, int n2){
        return Math.max(n1, n2);
    }
    public static int max(int n1, int n2, int n3){
        return max(n1, max(n2, n3));
    }
    public static int max(int n1, int n2, int n3, int n4){
        return max(n1, max(n2, n3, n4));
    }
    public static int max(int n1, int n2, int n3, int n4, int n5){
        return max(n1, max(n2, n3, n4, n5));
    }
}
