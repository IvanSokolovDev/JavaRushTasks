package com.javarush.task.task13.task1307;

/* 
Параметризованый интерфейс
*/

import javax.print.DocFlavor;

public class Solution {
    public static void main(String[] args) throws Exception {
    }

    interface SimpleObject<T> {
        SimpleObject<T> getInstance();
    }

    class StringObject implements SimpleObject<String> {
        String a;

        public StringObject(String par) {
            a = par;
        }

        @Override
        public SimpleObject<String> getInstance() {
            return this.getInstance();
        }
    }
}