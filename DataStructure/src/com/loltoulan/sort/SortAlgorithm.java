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
        System.out.println();

        JdkArraysSort.arraySort(Arrays.copyOf(arr, arr.length));
        System.out.println();
    }

}


class JdkArraysSort{

    public static void arraySort(int[] arr) {
        System.out.println("before arraySort \t ==> " + Arrays.stream(arr).boxed().toList());
        Arrays.sort(arr);
        System.out.println("after arraySort \t ==> " + Arrays.stream(arr).boxed().toList());
    }

}


// 快速排序
class QuickSort{

    public static void quickSort(int[] arr){
        System.out.println("before quickSort \t ==> " + Arrays.stream(arr).boxed().toList());
        int[] ints = quickS(arr, 0, arr.length - 1);
        System.out.println("after quickSort \t ==> " + Arrays.stream(ints).boxed().toList());
    }

    private static int[] quickS(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickS(arr, left, partitionIndex - 1);
            quickS(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
        System.out.println("before bubbleSort \t ==> " + Arrays.stream(arr).boxed().toList());
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
        System.out.println("after bubbleSort \t ==> " + Arrays.stream(arr).boxed().toList());
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
        System.out.println("before selectSort \t ==> " + Arrays.stream(arr).boxed().toList());
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
        System.out.println("after selectSort \t ==> " + Arrays.stream(arr).boxed().toList());
    }

}

// 插入排序
class InsertSort{

    /**
     * 时间复杂度 O(n^2) <br/>
     * 空间复杂度 O(1) <br/>
     * @param arr 待排序数组
     */
    public static void insertSort(int[] arr){
        System.out.println("before insertSort \t ==> " + Arrays.stream(arr).boxed().toList());
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            int temp = arr[i];
            while (j > 0 && arr[j - 1] > temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            // 存在比其小的数，插入
            if (j != i) {
                arr[j] = temp;
            }
        }
        System.out.println("after insertSort \t ==> " + Arrays.stream(arr).boxed().toList());
    }

}

// 希尔排序，本质是插入排序的一种优化
class ShellSort{

    /**
     * 时间复杂度 最坏 O(n^2) 平均O(nlog^2 n) <br/>
     * 空间复杂度 O(1) <br/>
     * @param arr 待排序数组
     */
    public static void shellSort(int[] arr){
        System.out.println("before shellSort \t ==> " + Arrays.stream(arr).boxed().toList());
        int length = arr.length;
        int temp;
        for (int step = length / 2; step >= 1; step /= 2) {
            for (int i = step; i < length; i++) {
                int j = i - step;
                temp = arr[i];
                while (j >= 0 && arr[j] > temp) {
                    arr[j + step] = arr[j];
                    j = j - step;
                }
                arr[j + step] = temp;
            }
        }
        System.out.println("after shellSort \t ==> " + Arrays.stream(arr).boxed().toList());
    }

}

// 二分插入排序
class BinaryInsertSort{

    public static void binaryInsertSort(int[] arr){

    }

}

// 归并排序
class MergeSort{

    public static void mergeSort(int[] arr){

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

