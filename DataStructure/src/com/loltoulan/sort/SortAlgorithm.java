package com.loltoulan.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        BucketSort.bucketedSort(Arrays.copyOf(arr, arr.length));
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
        System.out.println("before binaryInsertSort \t ==> " + Arrays.stream(arr).boxed().toList());
        bISort(arr);
        System.out.println("after binaryInsertSort \t\t ==> " + Arrays.stream(arr).boxed().toList());
    }

    public static void bISort(int[] array) {
        if (array.length < 2) {
            return;
        }
        // 记录当轮的值
        int value = 0;
        int low = 0, high = 0, middle = 0;
        for (int i = 1; i < array.length; i++) {
            low = 0;
            value = array[i];
            high = i - 1;
            while (low <= high) {
                middle = (high + low) >> 1;
                if (value < array[middle]) {
                    // 插入点为低半区，否则插入点在高半区
                    high = middle - 1;
                } else {
                    low = middle + 1;
                }
            }

            // 已经用临时变量value记录了需要挪动的位置值，此时从后往前将插入点后面所有元素往后挪动一位
            for (int j = i - 1; j >= low; j--) {
                array[j+ 1] = array[j];
            }
            //都往后挪动完了，再插入准确位置
            array[low] = value;
        }
    }


}

// 归并排序
class MergeSort{

    public static void mergeSort(int[] arr){
        System.out.println("before mergeSort \t ==> " + Arrays.stream(arr).boxed().toList());
        int[] merged = mergeS(arr);
        System.out.println("after mergeSort \t ==> " + Arrays.stream(merged).boxed().toList());
    }

    private static int[] mergeS(int[] sourceArr) {
        int[] arr = Arrays.copyOf(sourceArr, sourceArr.length);
        if (arr.length < 2) {
            return arr;
        }
        int middle = (int) Math.floor((double) arr.length / 2);

        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);

        return merge(mergeS(left), mergeS(right));
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;
        while (left.length > 0 && right.length > 0) {
            if (left[0] <= right[0]) {
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            }else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }

        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }

        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }
        return result;
    }

}

// 堆排序
class HeapSort{

    public static void heapSort(int[] sourceArray) {
        System.out.println("before heapSort \t ==> " + Arrays.stream(sourceArray).boxed().toList());
        int[] heapSort = heapS(sourceArray);
        System.out.println("after heapSort \t\t ==> " + Arrays.stream(heapSort).boxed().toList());

    }

    private static int[] heapS(int[] sourceArray) {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        int len = arr.length;

        buildMaxHeap(arr, len);

        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            len--;
            heapify(arr, 0, len);
        }
        return arr;
    }

    private static void buildMaxHeap(int[] arr, int len) {
        for (int i = (int) (double) (len / 2); i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    private static void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, len);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}

// 计数排序
class CountSort{

    public static void countSort(int[] sourceArray){
        System.out.println("before countSort \t ==> " + Arrays.stream(sourceArray).boxed().toList());
        int[] arr = countS(sourceArray);
        System.out.println("after countSort \t ==> " + Arrays.stream(arr).boxed().toList());
    }

    public static int[] countS(int[] sourceArray) {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int maxValue = getMaxValue(arr);
        return countingSort(arr, maxValue);
    }

    private static int[] countingSort(int[] arr, int maxValue) {
        int bucketLen = maxValue + 1;
        int[] bucket = new int[bucketLen];

        for (int value : arr) {
            bucket[value]++;
        }

        int sortedIndex = 0;
        for (int j = 0; j < bucketLen; j++) {
            while (bucket[j] > 0) {
                arr[sortedIndex++] = j;
                bucket[j]--;
            }
        }
        return arr;
    }

    private static int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int value : arr) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        return maxValue;
    }

}

// 基数排序
class RadixSort{

    public static void radixSort(int[] arr){
        System.out.println("before radixSort \t ==> " + Arrays.stream(arr).boxed().toList());
        arr = sort(arr);
        System.out.println("after radixSort \t ==> " + Arrays.stream(arr).boxed().toList());
    }

    public static int[] sort(int[] sourceArray) {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        int maxDigit = getMaxDigit(arr);
        return radixSort(arr, maxDigit);
    }

    /**
     * 获取最高位数
     */
    private static int getMaxDigit(int[] arr) {
        int maxValue = getMaxValue(arr);
        return getNumLenght(maxValue);
    }

    private static int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int value : arr) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    protected static int getNumLenght(long num) {
        if (num == 0) {
            return 1;
        }
        int lenght = 0;
        for (long temp = num; temp != 0; temp /= 10) {
            lenght++;
        }
        return lenght;
    }

    private static int[] radixSort(int[] arr, int maxDigit) {
        int mod = 10;
        int dev = 1;

        for (int i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
            // 考虑负数的情况，这里扩展一倍队列数，其中 [0-9]对应负数，[10-19]对应正数 (bucket + 10)
            int[][] counter = new int[mod * 2][0];

            for (int k : arr) {
                int bucket = ((k % mod) / dev) + mod;
                counter[bucket] = arrayAppend(counter[bucket], k);
            }

            int pos = 0;
            for (int[] bucket : counter) {
                for (int value : bucket) {
                    arr[pos++] = value;
                }
            }
        }

        return arr;
    }

    /**
     * 自动扩容，并保存数据
     *
     * @param arr
     * @param value
     */
    private static int[] arrayAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }



}

// 桶排序
class BucketSort{
    private static final BucketSort bucketSort = new BucketSort();
    public static void bucketedSort(int[] sourceArray){
        System.out.println("before bucketedSort \t ==> " + Arrays.stream(sourceArray).boxed().toList());
        bucketSort.bucketSort(sourceArray);
        System.out.println("after bucketedSort \t\t ==> " + Arrays.stream(sourceArray).boxed().toList());
    }

    public void bucketSort(int[] nums) {
        int n = nums.length;
        int mn = nums[0], mx = nums[0];
        // 找出数组中的最大最小值
        for (int i = 1; i < n; i++) {
            mn = Math.min(mn, nums[i]);
            mx = Math.max(mx, nums[i]);
        }
        int size = (mx - mn) / n + 1; // 每个桶存储数的范围大小，使得数尽量均匀地分布在各个桶中，保证最少存储一个
        int cnt = (mx - mn) / size + 1; // 桶的个数，保证桶的个数至少为1
        List<Integer>[] buckets = new List[cnt]; // 声明cnt个桶
        for (int i = 0; i < cnt; i++) {
            buckets[i] = new ArrayList<>();
        }
        // 扫描一遍数组，将数放进桶里
        for (int num : nums) {
            int idx = (num - mn) / size;
            buckets[idx].add(num);
        }
        // 对各个桶中的数进行排序，这里用库函数快速排序
        for (int i = 0; i < cnt; i++) {
            buckets[i].sort(null); // 默认是按从小打到排序
        }
        // 依次将各个桶中的数据放入返回数组中
        int index = 0;
        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                nums[index++] = buckets[i].get(j);
            }
        }
    }

}

