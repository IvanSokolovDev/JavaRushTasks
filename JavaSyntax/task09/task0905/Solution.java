package com.javarush.task.pro.task09.task0905;

import java.util.regex.Pattern;

/* 
Восьмеричный конвертер
*/

public class Solution {
    public static void main(String[] args) {
        int decimalNumber = 21;
        System.out.println("Десятичное число " + decimalNumber + " равно восьмеричному числу " + toOctal(decimalNumber));
        int octalNumber = 25;
        System.out.println("Восьмеричное число " + octalNumber + " равно десятичному числу " + toDecimal(octalNumber));
    }

    public static int toOctal(int decimalNumber) {
        //напишите тут ваш код
        int result = 0;
        int index = 0;

        while (decimalNumber > 0){
            result += Math.pow(10, index) * (decimalNumber % 8);
            index++;
            decimalNumber /= 8;
        }
        return result;
    }

    public static int toDecimal(int octalNumber) {
        //напишите тут ваш код
        int result = 0;
        int index = 0;

        while (octalNumber > 0){
            result += Math.pow(8, index) * (octalNumber % 10);
            index++;
            octalNumber /= 10;
        }
        return result;
    }
}
