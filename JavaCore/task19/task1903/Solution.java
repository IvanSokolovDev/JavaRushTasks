package com.javarush.task.task19.task1903;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Адаптация нескольких интерфейсов
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
    }

    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData data;

        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }

        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName() {
            String firstName = data.getContactFirstName();
            String lastName = data.getContactLastName();

            return String.format("%s, %s", lastName, firstName);
        }

        @Override
        public String getPhoneNumber() {
            String phoneNumber = String.valueOf(data.getPhoneNumber());
            String phoneCode = String.valueOf(data.getCountryPhoneCode());

            while (phoneNumber.length() < 10) {
                phoneNumber = "0".concat(phoneNumber);
            }

            String str1 = phoneNumber.substring(0, 3);
            String str2 = phoneNumber.substring(3, 6);
            String str3 = phoneNumber.substring(6, 8);
            String str4 = phoneNumber.substring(8);

            phoneNumber = String.format("+%s(%s)%s-%s-%s", phoneCode, str1, str2, str3, str4);

            return phoneNumber;
        }
    }

//    public static class Data implements IncomeData {
//        @Override
//        public String getCountryCode() {
//            return "UA";
//        }
//
//        @Override
//        public String getCompany() {
//            return "JavaRush Ltd.";
//        }
//
//        @Override
//        public String getContactFirstName() {
//            return "Ivan";
//        }
//
//        @Override
//        public String getContactLastName() {
//            return "Ivanov";
//        }
//
//        @Override
//        public int getCountryPhoneCode() {
//            return 38;
//        }
//
//        @Override
//        public int getPhoneNumber() {
//            return 71112233;
//        }
//    }
    public interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example1: 501234567, For example2: 71112233
    }

    public interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example1: +38(050)123-45-67, For example2: +38(007)111-22-33
    }
}