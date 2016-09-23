package com.example.complexity;

import java.util.Random;

/**
 * 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
//        int[] arr = {2, 3, 5, 8, 9, 11, 1, 4, 7, 12, 18};
//        int[] tempArr = new int[arr.length];
//        mergeArrToTemArr(arr, tempArr, 0, 6, 10);
//        for (int k = 0; k < tempArr.length; k++) {
//            System.out.print(tempArr[k] + ",");
//        }
        /********************************************************************/
        int len = 100;
        int[] arr = new int[len];
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            arr[i] = random.nextInt(len);
        }
        mergerSort(arr);
        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k] + ",");
        }
    }
    /*********************************递归归并************************************/


    /**
     * 合并 leftStart 到rightStart-1 位置有序数组 和 rightStart 到rightEnd位置有序数组 为一个整体有序的数组
     *
     * @param arr
     * @param leftStart
     * @param rightStart
     * @param rightEnd
     * @return
     */
    private static void mergeArrToArr(int[] arr, int[] temArr, int leftStart, int rightStart, int rightEnd) {

//        long start = System.currentTimeMillis();
//        int forN = 0;
//        int swapN = 0;


        int leftEnd = rightStart - 1;
        int tempStart = leftStart;
        int nums = rightEnd - leftStart + 1;
        while (leftStart <= leftEnd && rightStart <= rightEnd) {
            if (arr[leftStart] < arr[rightStart]) {
                temArr[tempStart++] = arr[leftStart++];

            } else {
                temArr[tempStart++] = arr[rightStart++];
            }
//            swapN++;
//            forN++;
        }

        while (leftStart <= leftEnd) {
            temArr[tempStart++] = arr[leftStart++];
//            swapN++;
//            forN++;
        }
        while (rightStart <= rightEnd) {
            temArr[tempStart++] = arr[rightStart++];
//            swapN++;
//            forN++;
        }
        for (int i = 0; i < nums; i++, rightEnd--) {
            arr[rightEnd] = temArr[rightEnd];
        }
//        long end = System.currentTimeMillis();
//        System.out.println("mergeArrToArr coast time:" + (end - start));
//        System.out.println("mergeArrToArr for count:" + forN);
//        System.out.println("mergeArrToArr swap count:" + swapN);
    }

    private static void sortRecursion(int[] arr, int[] tempArr, int left, int right) {
        int center;
        if (left < right) {
            center = (left + right) / 2;
            sortRecursion(arr, tempArr, left, center);
            sortRecursion(arr, tempArr, center + 1, right);
            mergeArrToArr(arr, tempArr, left, center + 1, right);
        }
    }

    public static void mergerSortRecursion(int[] srcArr) {
        long start = System.currentTimeMillis();
        int[] desArr = new int[srcArr.length];
        sortRecursion(srcArr, desArr, 0, srcArr.length - 1);
        long end = System.currentTimeMillis();
        System.out.println("mergeArrToArr coast time:" + (end - start));
    }

    /********************************非递归归并*************************************/
    /**
     * 合并 leftStart 到rightStart-1 位置有序数组 和 rightStart 到rightEnd位置有序数组 为一个整体有序的数组
     *
     * @param arr        待排序的数组
     * @param leftStart
     * @param rightStart
     * @param rightEnd
     * @return
     */
    private static void mergeArrToTemArr(int[] arr, int[] temArr, int leftStart, int rightStart, int rightEnd) {
        int leftEnd = rightStart - 1;
        int tempStart = leftStart;
        while (leftStart <= leftEnd && rightStart <= rightEnd) {
            if (arr[leftStart] < arr[rightStart]) {
                temArr[tempStart++] = arr[leftStart++];
            } else {
                temArr[tempStart++] = arr[rightStart++];
            }
        }

        while (leftStart <= leftEnd) {
            temArr[tempStart++] = arr[leftStart++];

        }
        while (rightStart <= rightEnd) {
            temArr[tempStart++] = arr[rightStart++];
        }
    }

    /**
     * @param arr     待排序数组
     * @param tempArr 临时数组
     * @param len     当前子列长度
     */
    private static void mergerPass(int[] arr, int[] tempArr, int len) {
        int i;
        for (i = 0; i <= arr.length - 2 * len; i += 2 * len) {/**归并长度为len的两个相邻子列*/
            mergeArrToTemArr(arr, tempArr, i, i + len, i + 2 * len - 1);
        }
        if (i + len < arr.length) {/**归并最后两个子列*/
            mergeArrToTemArr(arr, tempArr, i, i + len, arr.length - 1);
        } else {/**只剩最后1个子列*/
            for (int j = i; j < arr.length; j++) {
                tempArr[j] = arr[j];
            }
        }
    }

    public static void mergerSort(int[] arr) {
        long start = System.currentTimeMillis();
        int len = 1;/**初始子列的长度*/
        int[] tempArr = new int[arr.length];
        while (len < arr.length) {
            mergerPass(arr, tempArr, len);
            len *= 2;
            mergerPass(tempArr, arr, len);
            len *= 2;
        }
        long end = System.currentTimeMillis();
        System.out.println("mergeArrToArr coast time:" + (end - start));
    }


}
