package org.example;
//Пусть дан произвольный список целых чисел.

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Iterator;

// 1) Нужно удалить из него чётные числа
// 2) Найти минимальное значение
// 3) Найти максимальное значение
// 4) Найти среднее значение
public class Main {
    public static void main(String[] args)
    {
        ArrayList<Integer> list = new ArrayList<>();
        Random rand = new Random();
        for(int i = 0; i < 100000; i++) {list.add(rand.nextInt(10));}
//        System.out.println(list);

        DeleteEvenNumbers(list);
//        System.out.println(list);
//        System.out.println(GetMaxValue(list));
//        System.out.println(GetMinValue(list));
//        System.out.println(GetArithmeticMeanValue(list));
    }
    static ArrayList DeleteEvenNumbers(ArrayList list) //Не указали тип, можем получать любые списки))
    {
        long startTime = System.nanoTime();
        int index = 0;
        while (index < list.size())
        {
            if ((int) list.get(index) % 2 == 0) {list.remove(index);}
            else {index++;}
        }
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);
        return list;

        //Интересно что работает быстрее?

//      long startTime = System.nanoTime();
//      Iterator iterator = list.iterator();
//      while(iterator.hasNext())
//      {
//          if((int)iterator.next() % 2 == 0) {iterator.remove();}
//      }
//        long endTime = System.nanoTime();
//        long timeElapsed = endTime - startTime;
//        System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);
//      return list;
    }

    static int GetMaxValue(ArrayList<Integer> list)
    {
        int value = list.get(0);
        for(Integer num : list) {if(num > value) {value = num;}}
        return value;
    }

    static int GetMinValue(ArrayList<Integer> list)
    {
        int value = list.get(0);
        for(Integer num : list) {if(num < value) {value = num;}}
        return value;
    }

    static double GetArithmeticMeanValue(ArrayList<Integer> list)
    {
        int value = 0;
        for(Integer num : list){value += num;}
        return (double)value / list.size();
    }
}