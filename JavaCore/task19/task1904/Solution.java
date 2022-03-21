package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {
        try {
            new PersonScannerAdapter(new Scanner("Иванов Иван Иванович 31 12 1950")).read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String currentString = fileScanner.nextLine();
            String[] strings = currentString.split(" ");

            String surname = strings[0];
            String name = strings[1];
            String patronymic = strings[2];
            String day = strings[3];
            String month = strings[4];
            String year = strings[5];

            String fullDate = String.format("%s %s %s", day, month, year);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy");

            try {
                Date date = simpleDateFormat.parse(fullDate);
                System.out.println(date);
                Person person = new Person(name, patronymic, surname, date);
                return person;
            } catch (ParseException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
