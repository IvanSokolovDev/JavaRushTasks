package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

/*
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        String fileName = args[0];
        String fileText = "";

        try (FileReader fileReader = new FileReader(fileName)) {
            while (fileReader.ready()) {
                char currentChar = (char) fileReader.read();
                fileText = fileText.concat(Character.toString(currentChar));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(fileText);

        while (scanner.hasNext()) {
            String[] currentString  = scanner.nextLine().split(" ");
            String name = "";

            int day = Integer.parseInt(currentString[currentString.length - 3]);
            int month = Integer.parseInt(currentString[currentString.length - 2]) - 1;
            int year = Integer.parseInt(currentString[currentString.length - 1]);

            Calendar calendar = new GregorianCalendar(year, month, day);

//            currentString = Arrays.copyOfRange(currentString, 0, currentString.length - 1);
//
//            for (String man : currentString) {
//                name = name.concat(man).concat(" ");
//            }

            for (int i = 0; i < currentString.length - 3; i++) {
                name = name.concat(currentString[i]).concat(" ");
            }

            PEOPLE.add(new Person(name.trim(), calendar.getTime()));
        }

        PEOPLE.forEach(elem -> System.out.println(elem.getName() + elem.getBirthDate()));
    }
}

