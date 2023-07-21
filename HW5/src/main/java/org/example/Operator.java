package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Operator
{

    public static void Add(Map<String, List<String>> phonebook, String[] newRecord)
    {
        String name = newRecord[0];
        String phone = newRecord[1];

        if (phonebook.containsKey(name)){phonebook.get(name).add(phone);}
        else{phonebook.put(name, new ArrayList<>(Collections.singletonList(phone)));}
    }
    public static String[] New()
    {
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter a name: ");
        String name = userInput.nextLine().replaceAll("[^0-9a-zA-Zа-яёА-ЯЁ\\. ]", "").strip();
        System.out.print("Enter a phone umber: ");
        String phoneNum = userInput.nextLine().replaceAll("[^\\(\\)0-9\\-\\+]", "").strip();

        if (name.isEmpty()){name = "unknown";}
        else {name = name.substring(0,1).toUpperCase() + name.substring(1);}
        if (phoneNum.isEmpty()){phoneNum = "empty";}
        return new String[] {name, phoneNum};
    }

    public static void Save(File dataFile, Map<String, List<String>> phonebook)
    {
        if (!dataFile.exists())
        {
            try {dataFile.createNewFile();}
            catch (IOException e) {System.out.println(e.getMessage());}
        }

        if(dataFile.canWrite())
        {
            try (FileWriter filewriter = new FileWriter(dataFile, false))
            {
                for (var line: phonebook.entrySet())
                {
                    List<String> phonesList = line.getValue();

                    for (int i = 0; i< phonesList.size(); i++)
                    {
                        filewriter.write(line.getKey() + ":");
                        filewriter.write( phonesList.get(i)+ "\n");
                    }
                }
                filewriter.flush();
            } catch (IOException e) {System.out.println(e.getMessage());}
        }
    }

    public static Map<String, List<String>> LoadPhonebook(File dataFile)
    {
        Map<String, List<String>> phonebook = new HashMap<>();

        if (!dataFile.exists())
        {
            try {dataFile.createNewFile();}
            catch (IOException ex) {System.out.println(ex.getMessage());}
        }

        if(dataFile.canRead())
        {
            try {Scanner fileScanner = new Scanner(dataFile);
                while (fileScanner.hasNextLine())
                {
                    Add(phonebook, fileScanner.nextLine().split(":"));
                }
                fileScanner.close();
            } catch (FileNotFoundException e) {System.out.println("READ ERROR");throw new RuntimeException(e);}}
        return phonebook;
    }
}
