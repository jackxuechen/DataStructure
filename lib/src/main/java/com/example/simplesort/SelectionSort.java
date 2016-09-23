package com.example.simplesort;

/**
 * 选择排序
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 7, 9, 2, 3};

        int[] ints = selectionSort(arr);
        for (int k = 0; k < ints.length; k++) {
            System.out.print(ints[k] + ",");
        }
    }


    public static int[] selectionSort(int[] arr) {
        long start = System.currentTimeMillis();
        int n = 0;
        int tempSwap;
        for (int i = 0; i < arr.length - 1; i++) {
            int tempIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[tempIndex]) {
                    tempIndex = j;
                }
                n++;
            }
            tempSwap = arr[tempIndex];
            arr[tempIndex] = arr[i];
            arr[i] = tempSwap;

        }
        long end = System.currentTimeMillis();
        System.out.println("time:" + (end - start));
        System.out.println("count:" + n);
        return arr;
    }


}
