package com.javarush.task.task14.task1420;

import java.util.Scanner;

/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int firstNum = 0;
        int secondNum = 0;

        int countPositive = 0;
        Scanner inputNumber;
        int temp = 0;

        while (countPositive < 2) {
            inputNumber = new Scanner(System.in);
            temp = Integer.parseInt(inputNumber.nextLine());

            if (temp > 0) {
                if (countPositive == 0) {
                    firstNum = temp;
                    countPositive++;
                } else if (countPositive == 1) {
                    secondNum = temp;
                    countPositive++;
                }
            }
        }

        System.out.println(NOD(firstNum, secondNum));
    }

    public static int NOD(int n1, int n2) {
        int div = 1;

        for (int i = 1; i <= n1 && i <= n2; i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                div = i;
            }
        }

        return div;
    }
}
