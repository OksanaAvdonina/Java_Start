package org.example;

import java.io.File;
import java.util.*;

public class Program {
    public static void main(String[] args)
    {
        System.out.println("Phonebook");
        File dataFile = new File("ContactList.txt");

        Map <String, List<String>> phonebook = Operator.LoadPhonebook(dataFile);
        boolean menu = true;

        while (menu)
        {
            switch (Select())
            {
                case 1:
                    Operator.Add(phonebook, Operator.New());
                    Operator.Save(dataFile, phonebook);
                    break;
                case 2:
                    Operator.LoadPhonebook(dataFile);
                    Printer.PrintPhonebook(Sorter.SortByName(phonebook));
                    break;
                case 3:
                    Printer.PrintPhonebook(Sorter.SortByPhoneCount(phonebook));
                    break;
                case 4:
                    menu = false;
            }
        }
    }
    public static Integer Select()
    {
        Scanner input = new Scanner(System.in);

        System.out.println("1 - add contact");
        System.out.println("2 - show contacts");
        System.out.println("3 - show sorted by phones count");
        System.out.println("4 - exit");
        System.out.print("Выберите: ");

        String userInput = input.nextLine();
        while(!userInput.matches("[1-4]"))
        {
            System.out.print("Incorrect input, try again: ");
            userInput = input.nextLine();
        }
        return Integer.parseInt(userInput);
    }
}