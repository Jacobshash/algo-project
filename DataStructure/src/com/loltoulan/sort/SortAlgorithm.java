package com.loltoulan.sort;

import java.util.Arrays;

public class SortAlgorithm {

    // 十大排序算法
    public static void main(String[] args) {
        int[] arr = {5, 4, 6, 3, 2, 6, 1};
        BubbleSort.bubbleSort(Arrays.copyOf(arr, arr.length));
        System.out.println();

        SelectSort.selectSort(Arrays.copyOf(arr, arr.length));
        System.out.println();

        InsertSort.insertSort(Arrays.copyOf(arr, arr.length));
        System.out.println();

        ShellSort.shellSort(Arrays.copyOf(arr, arr.length));
        System.out.println();

        MergeSort.mergeSort(Arrays.copyOf(arr, arr.length));
        System.out.println();

        QuickSort.quickSort(Arrays.copyOf(arr, arr.length));
        System.out.println();

        HeapSort.heapSort(Arrays.copyOf(arr, arr.length));
        System.out.println();

        CountSort.countSort(Arrays.copyOf(arr, arr.length));
        System.out.println();

        RadixSort.radixSort(Arrays.copyOf(arr, arr.length));
        System.out.println();

        BucketSort.bucketSort(Arrays.copyOf(arr, arr.length));
        System.out.println();

        BinaryInsertSort.binaryInsertSort(Arrays.copyOf(arr, arr.length));
    }

}

// 冒泡排序
class BubbleSort{

    /**
     * 时间复杂度 O(n^2) <br/>
     * 空间复杂度 O(1) <br/>
     * @param arr 待排序数组
     */
    public static void bubbleSort(int[] arr){
        System.out.println("before bubbleSort ==> " + Arrays.stream(arr).boxed().toList());
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("after bubbleSort ==> " + Arrays.stream(arr).boxed().toList());
    }

}

// 选择排序
class SelectSort{

    /**
     * 时间复杂度 O(n^2) <br/>
     * 空间复杂度 O(1) <br/>
     * @param arr 待排序数组
     */
    public static void selectSort(int[] arr){
        System.out.println("before selectSort ==> " + Arrays.stream(arr).boxed().toList());
        int length = arr.length;
        for (int i = 0; i < length-1; i++) {
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (i != min) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        System.out.println("after selectSort ==> " + Arrays.stream(arr).boxed().toList());
    }

}

// 插入排序
class InsertSort{

    public static void insertSort(int[] arr){

    }

}

// 希尔排序
class ShellSort{

    public static void shellSort(int[] arr){

    }

}

// 归并排序
class MergeSort{

    public static void mergeSort(int[] arr){

    }

}

// 快速排序
class QuickSort{

    public static void quickSort(int[] arr){

    }

}

// 堆排序
class HeapSort{

    public static void heapSort(int[] arr){

    }

}

// 计数排序
class CountSort{

    public static void countSort(int[] arr){

    }

}

// 基数排序
class RadixSort{

    public static void radixSort(int[] arr){

    }

}

// 桶排序
class BucketSort{

    public static void bucketSort(int[] arr){

    }

}

// 二分插入排序
class BinaryInsertSort{

    public static void binaryInsertSort(int[] arr){

    }

}
