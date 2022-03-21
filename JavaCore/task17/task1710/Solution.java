package com.javarush.task.task17.task1710;

import javax.print.DocFlavor;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD
*/

public class Solution {
    public static SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    public static SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    public static List<Person> allPeople = new ArrayList<>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }


    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (args[0].equals("-c")) {
            String name = args[1];
            String sex = args[2];
            Date bd = null;

            try {
                bd = simpleDateFormat1.parse(args[3]);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (sex.equals("м")) {
                allPeople.add(Person.createMale(name, bd));
            } else if (sex.equals("ж")) {
                allPeople.add(Person.createFemale(name, bd));
            }

            System.out.println(allPeople.size() - 1);

        } else if (args[0].equals("-r")) {
            int index = Integer.parseInt(args[1]);

            Date date = allPeople.get(index).getBirthDate();
            String name = allPeople.get(index).getName();
            String sex = "";

            if (allPeople.get(index).getSex() == Sex.MALE) {
                sex = "м";
            } else if (allPeople.get(index).getSex() == Sex.FEMALE) {
                sex = "ж";
            }

            String bd = simpleDateFormat2.format(date);

            System.out.printf("%s %s %s", name, sex, bd);
        } else if (args[0].equals("-u")) {
            int index = Integer.parseInt(args[1]);

            String name = args[2];
            Sex sex = null;

            if (args[3].equals("м")) {
                sex = Sex.MALE;
            } else if (args[3].equals("ж")) {
                sex = Sex.FEMALE;
            }

            String bd = args[4];

            Person person = allPeople.get(index);

            person.setName(name);
            person.setSex(sex);

            try {
                person.setBirthDate(simpleDateFormat1.parse(bd));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else if (args[0].equals("-d")) {
            int index = Integer.parseInt(args[1]);
            Person person = allPeople.get(index);

            person.setName(null);
            person.setSex(null);
            person.setBirthDate(null);
        }
    }
}
