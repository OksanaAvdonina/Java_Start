// 1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
// 2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
// 3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
// 4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2

// *Пункты реализовать в разных методах
//int i = new Random().nextInt(k); //это кидалка случайных чисел!)

package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int i = GetRandomNum();
        System.out.println("Рандомное число: " + i);
        System.out.println(Short.MIN_VALUE);
        int n = GetNumHighestBit(i);
        System.out.println("Старший значащий бит: " + n);

        Scanner scanner = new Scanner(System.in);
        System.out.printf("Для кратных нажмите 1, для некратных 2...:");
        int input = scanner.nextInt();
        scanner.close();

        int []arrSize = CountArraySize(i, n, input);

        if(input == 1) {
            int[] m1 = FillArrayOfMultiples(i, n, arrSize[0]);
            PrintArray(m1);
        }
        if (input == 2) {
            int[] m2 = FillArrayOfNonMultiples(i, n, arrSize[1]);
            PrintArray(m2);
        }
    }

    static int GetRandomNum(){
        return new Random().nextInt(0, 2000);
    }
    static int GetNumHighestBit(int i){
        return Integer.toBinaryString(i).length();
    }
    static int[] CountArraySize(int i, int n, int num){

        int MulCounter = 0;
        int NonMulCounter = 0;

        for (;i < Short.MAX_VALUE; i++){
            if(i % n == (num - 1)) {MulCounter++;}
        }
        for(;i > Short.MIN_VALUE; i--){
            if(i % n != (num - 2)) {NonMulCounter++;}
        }
        int[]arr = new int[2];
        arr[0] = MulCounter;
        arr[1] = NonMulCounter;
        return arr;
    }
    static int[] FillArrayOfMultiples(int i, int n, int size){
        int[] array = new int[size];

        for(int j = 0; i < Short.MAX_VALUE; i++){
            if(i % n == 0) {
                array[j] = i;
                j++;
            }
        }
        return array;
    }
    static int[] FillArrayOfNonMultiples(int i, int n, int size) {
        int[] array = new int[size];

        for (int j = 0; Short.MIN_VALUE < i; i--) {
            if (i % n != 0) {
                array[j] = i;
                j++;
            }
        }
        return array;
    }
    static void PrintArray(int[]arr){
        for (int k = 0; k < arr.length; k++){
            System.out.println(arr[k] + ' ');}
    }
}