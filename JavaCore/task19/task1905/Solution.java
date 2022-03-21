package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {

    }

    public static class DataAdapter implements RowItem {
        private final Customer customer;
        private final Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            Set<Map.Entry<String, String>> allCountries = countries.entrySet();
            String countyName = customer.getCountryName();

            for (Map.Entry<String, String> country : allCountries) {
                if (country.getValue().equals(countyName)) {
                    return country.getKey();
                }
            }

            return null;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String[] fullName = contact.getName().split(", ");
            return fullName[1];
        }

        @Override
        public String getContactLastName() {
            String[] fullName = contact.getName().split(", ");
            return fullName[0];
        }

        @Override
        public String getDialString() {
            String phoneNumber = contact.getPhoneNumber()
                    .replaceAll("\\(", "")
                    .replaceAll("\\)", "")
                    .replaceAll("-", "");
            return "callto://".concat(phoneNumber);
        }
    }

    public interface RowItem {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        String getDialString();         //For example: callto://+380501234567
    }

    public interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}

