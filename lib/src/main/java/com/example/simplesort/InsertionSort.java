package com.example.simplesort;

/**
 * 插入排序
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 7, 9, 4, 2, 3};
        int[] ints = insertionSort(arr);
        for (int k = 0; k < ints.length; k++) {
            System.out.print(ints[k] + ",");
        }
    }

    public static int[] insertionSort(int[] arr) {
//        long start = System.currentTimeMillis();
//        long n = 0;
        int temp;
        int i;
        for (int p = 1; p < arr.length; p++) {
            temp = arr[p];
            for (i = p; i > 0 && arr[i - 1] > temp; i--) {
                arr[i] = arr[i - 1];
//                n++;

            }

            arr[i] = temp;
        }
//        long end = System.currentTimeMillis();
//        System.out.println("time:" + (end - start));
//        System.out.println("count:" + n);
        return arr;
    }
}
