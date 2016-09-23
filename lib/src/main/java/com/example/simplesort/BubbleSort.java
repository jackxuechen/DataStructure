package com.example.simplesort;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 7, 9, 2, 3};
        int[] ints = bubbleSort(arr);
        for (int k = 0; k < ints.length; k++) {
            System.out.print(ints[k] + ",");
        }
    }


    public static int[] bubbleSort(int[] arr) {
        long start = System.currentTimeMillis();
        int n = 0;
        int tempSwap;
        int flag;
        for (int i = arr.length - 1; i >= 0; i--) {
            flag = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    tempSwap = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tempSwap;
                    flag = 1;
                }
                n++;
            }

            if (flag == 0) {
                break;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("time:" + (end - start));
        System.out.println("count:" + n);
        return arr;
    }


}
