package com.example.complexity;

import java.util.Random;

/**
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
//        int[] arr = {2, 3, 5, 8, 9, 11, 1, 4, 7, 12, 18};
        int len = 100;
        int[] arr = new int[len];
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            arr[i] = random.nextInt(len);
        }
        quickSort(arr);
        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k] + ",");
        }
    }

    public static int medianIn3(int[] arr, int left, int right) {
        int center = (left + right) / 2;
        if (arr[left] > arr[center]) {
            swap(arr, left, center);
        }
        if (arr[left] > arr[right]) {
            swap(arr, left, right);
        }
        if (arr[center] > arr[right]) {
            swap(arr, center, right);
        }
        /**
         *将基准pivot藏到右边,这样排序的时候只需要考虑arr[left+1]到arr[right-2]
         */
        swap(arr, center, right - 1);

        return arr[right - 1];//返回基准Pivot
    }


    private static void qSort(int[] arr, int left, int right) {
        int cutOff = 8;
        int pivot;
        int low;
        int high;
        int temp;
        if (cutOff <= right - left) {
            pivot = medianIn3(arr, left, right);
            low = left;
            high = right - 1;
            while (true) {

                while (arr[++low] < pivot) ;
                while (arr[--high] > pivot) ;
                if (low < high) {
                    swap(arr, low, high);
                } else {
                    break;
                }

            }
            swap(arr, low, right - 1);
            qSort(arr, left, low - 1);
            qSort(arr, low + 1, right);

        } else {
            int i;
            for (int p = left; p < right - left + 1; p++) {
                temp = arr[p];
                for (i = p; i > 0 && arr[i - 1] > temp; i--) {
                    arr[i] = arr[i - 1];
                }
                arr[i] = temp;
            }
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp;
        temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void quickSort(int[] arr) {
        long start = System.currentTimeMillis();
        qSort(arr, 0, arr.length - 1);
        long end = System.currentTimeMillis();
        System.out.println("mergeArrToArr coast time:" + (end - start));
    }


}
