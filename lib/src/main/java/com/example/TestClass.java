package com.example;

import com.example.complexity.QuickSort;

import java.util.Arrays;
import java.util.Random;

public class TestClass {
    public static void main(String[] args) {
        //        int[] arr = {3, 2, 1, 7, 9, 2, 3, 3, 2, 1, 7, 9, 2, 3, 3, 2, 1, 7, 9, 2, 3, 3, 2, 1, 7, 9, 2, 3, 3, 2, 1, 7, 9, 2, 3, 3, 2, 1, 7, 9, 2, 3};
        int len = 1000000;
        int[] arr = new int[len];
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            arr[i] = random.nextInt(len);
        }
//        defaultSort(arr);
        QuickSort.quickSort(arr);
//        ShellSort.shellSort(arr);
//        ShellSort.shellSortHibbard(arr);
//        MergeSort.mergerSortRecursion(arr);
//        MergeSort.mergerSort(arr);
//        BubbleSort.bubbleSort(arr);
//        SelectionSort.selectionSort(arr);
//        InsertionSort.insertionSort(arr);
//        for (int k = 0; k < ints.length; k++) {
//            System.out.print(ints[k] + ",");
//        }
    }

    public static void defaultSort(int[] arr) {
        long start = System.currentTimeMillis();
        Arrays.sort(arr);
        long end = System.currentTimeMillis();
        System.out.println("mergeArrToArr coast time:" + (end - start));

    }
}
