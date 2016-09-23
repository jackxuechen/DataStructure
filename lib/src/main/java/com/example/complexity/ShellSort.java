package com.example.complexity;

import com.example.simplesort.BubbleSort;

import java.util.Random;

/**
 * Created by liujie on 2016/9/19.
 */
public class ShellSort {

    public static void main(String[] args) {
//        int[] arr = {3, 2, 1, 7, 9, 2, 3, 3, 2, 1, 7, 9, 2, 3, 3, 2, 1, 7, 9, 2, 3, 3, 2, 1, 7, 9, 2, 3, 3, 2, 1, 7, 9, 2, 3, 3, 2, 1, 7, 9, 2, 3};
        int[] arr = new int[100000];
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            arr[i] = random.nextInt(100000);
        }
//        int[] ints = shellSort(arr);
        int[] ints = BubbleSort.bubbleSort(arr);
        for (int k = 0; k < ints.length; k++) {
            System.out.print(ints[k] + ",");
        }
    }

    public static int[] shellSort(int[] arr) {
        long start = System.currentTimeMillis();
        int n = 0;
        int temp;
        int p;
        int i;
        for (int d = arr.length / 2; d > 0; d = d / 2) {

            for (p = d; p < arr.length; p++) {
                temp = arr[p];
                for (i = p; i >= d && arr[i - d] > temp; i -= d) {
                    arr[i] = arr[i - d];
                    n++;
                }
                arr[i] = temp;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("time:" + (end - start));
        System.out.println("count:" + n);
        return arr;
    }


    public static int[] shellSortHibbard(int[] arr) {
        long start = System.currentTimeMillis();
        int forN = 0;
        int swapN = 0;
        int temp;
        int p;
        int i;
        for (int d = arr.length / 2 - 1; d > 0; d = d / 2 - 1) {
            d = d == 2 ? 1 : d;
            for (p = d; p < arr.length; p++) {
                temp = arr[p];
                for (i = p; i >= d && arr[i - d] > temp; i -= d) {
                    arr[i] = arr[i - d];
                    swapN++;
                    forN++;
                }
                arr[i] = temp;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("coast time:" + (end - start));
        System.out.println("for count:" + forN);
        System.out.println("swap count:" + swapN);
        return arr;
    }


}
