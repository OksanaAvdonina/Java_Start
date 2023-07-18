package org.example;

import java.util.*;

public class Main {
    static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        ArrayList<String> surname = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> lastname = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<Character> sex = new ArrayList<>();
        ArrayList<Integer> idAge = new ArrayList<>();
        ArrayList<Character> idSex = new ArrayList<>();
        ArrayList<Integer> sexCounted = new ArrayList<>();
        ArrayList<Integer> idSorted = new ArrayList<>();
        ArrayList<Integer> finalList = new ArrayList<>();

        int i = 0;

        while (true) {
            surname.add(scanner.nextLine());
            name.add(scanner.nextLine());
            lastname.add(scanner.nextLine());
            age.add(Integer.valueOf(scanner.nextLine()));
            sex.add(scanner.nextLine().charAt(0));
            idSex.add(sex.get(i));
            idAge.add(sex.size() - 1);
            String tmp = scanner.nextLine();
            i++;
            if (tmp.toLowerCase().contains("n")) break;
        }

        System.out.println("+".repeat(26));

        String tmp = scanner.nextLine();

        //Sorting by age
        if (tmp.contains("o")) {
            idAge.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return age.get(o1) - age.get(o2);
                }
            });
            FormatOutput sorting = new FormatOutput(idAge,idSex, name, surname, lastname, age, sex);
            System.out.println("--Сортировка по возрасту--".toUpperCase());
            sorting.OutputByAge();
        }

        System.out.println("+".repeat(22));

        tmp = scanner.nextLine();

        //Sorting by sex
        if(tmp.contains("o"))
        {
            sexCounted = MySort.countSex(idSex);
            idSorted = MySort.SortBySex(sexCounted, idSex);

            FormatOutput sorting = new FormatOutput(idAge, idSex, name, surname, lastname, age, sex);
            System.out.println("--Сортировка по полу--".toUpperCase());
            sorting.OutputBySex(idSorted);
        }

        System.out.println("+".repeat(22));

        tmp = scanner.nextLine();

        //Sorting by sex & age
        if(tmp.contains("B"))
        {
            finalList = MySort.SortBySexAndAge(age, sex);
            FormatOutput sorting = new FormatOutput(idAge, idSex, name, surname, lastname, age, sex);
            System.out.println(finalList);
            sorting.OutputByAgeAndSex(finalList);
        }
    }
}