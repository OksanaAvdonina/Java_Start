package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MySort
{
    public static ArrayList<Integer> countSex(ArrayList idSex)
    {
        ArrayList<Integer> count = new ArrayList<>();
        int maleCount = 0;
        int femaleCount = 0;
        for (Object item: idSex)
        {
            if(item.equals('м')) {maleCount++;}
            else{femaleCount++;}
        }
        count.add((maleCount));
        count.add(femaleCount);
        return count;
    }

    public static ArrayList<Integer> SortBySex(ArrayList list, ArrayList oldList)
    {
        ArrayList<Integer> newList = new ArrayList<>();

        for (int item = 0, i = 0; item < oldList.size(); item++)
        {
            if (oldList.get(item).equals('м')) {newList.add(i, item);i++;}
        }
        for (int item = 0, k = (int)list.get(0); item < oldList.size(); item++)
        {
            if (oldList.get(item).equals('ж')) {newList.add(k, item);k++;}
        }
        return newList;
    }
    public static ArrayList<Integer> SortBySexAndAge(ArrayList age, ArrayList sex)
    {
        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();
        for (int j = 0; j < sex.size(); j++)
        {
            if(sex.get(j).equals('м')) {leftList.add((Integer) age.get(j));}
        }
        for (int j = 0; j < sex.size(); j++)
        {
            if(sex.get(j).equals('ж')) {rightList.add((Integer) age.get(j));}
        }

        Collections.sort(leftList);
        Collections.sort(rightList);
        leftList.addAll(rightList);
        return leftList;
    }
}
