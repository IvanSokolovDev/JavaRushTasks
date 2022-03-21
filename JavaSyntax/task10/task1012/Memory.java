package com.javarush.task.pro.task10.task1012;

import java.util.Arrays;
import java.util.Objects;

/* 
Дефрагментация памяти
*/

public class Memory {

    public static void main(String[] args) {
        String[] memory = {"object15", null, null, "object2", null, null, null, "object32", null, "object4"};
        executeDefragmentation(memory);
        System.out.println(Arrays.toString(memory));
    }

    public static void executeDefragmentation(String[] array) {
        //напишите тут ваш код
        for (int i = 0; i < array.length; i++){
            if (Objects.equals(array[i],null)){
                int indexFinish = findIndex(array, null, i);
                swap(array, i, indexFinish);
            }
        }
    }

    public static int findIndex(String[] array, String findValue, int startIndex){
        int find = startIndex;

        for (int i = startIndex; i < array.length; i++){
            if (!Objects.equals(array[i], findValue)){
                find = i;
                return find;
            }
        }

        return find;
    }

    public static void swap(String[] array, int indexStart, int indexFinish){
        String temp = array[indexStart];
        array[indexStart] = array[indexFinish];
        array[indexFinish] = temp;
    }
}
