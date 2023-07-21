package org.example;

import java.util.List;
import java.util.Map;

public class Printer
{
    public static void PrintPhonebook(Map<String, List<String>> phonebook)
    {
        int maxNameLength = 0;
        int maxPhoneLength = 0;

        for (var record: phonebook.entrySet())
        {
            int currentNameLength = record.getKey().length();
            for (var phone: record.getValue())
            {
                int currentPhoneLength = phone.length();
                if (currentPhoneLength > maxPhoneLength) {maxPhoneLength = currentPhoneLength;}
            }
            if (currentNameLength > maxNameLength){maxNameLength = currentNameLength;}
        }

        int counter = 0;

        for (var record: phonebook.entrySet())
        {
            counter++;
            String name = record.getKey();
            List<String> phonesList = record.getValue();
            System.out.printf("│ %-" + maxNameLength + "s ", name);

            for (int i = 0; i < phonesList.size(); i++)
            {
                if (i == 0){System.out.printf("│ %-" + maxPhoneLength + "s │\n", phonesList.get(i));}
                else {System.out.printf("│ " + " ".repeat( maxNameLength ) + " │ %-" + maxPhoneLength + "s │\n", phonesList.get(i));}
            }
        }
    }
}
