package com.loltoulan.multipoint;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;


public class RotateArray {
    public static void main(String[] args) {
        // [1, 2, 3, 4, 5, 6]
        // 翻转一次 [6 ,1, 2, 3, 4, 5]
        // 翻转两次 [5 ,6, 1, 2, 3, 4]
        int[] nums = {1,2};
        RotateArray.rotateC(nums, 1);
        Arrays.stream(nums).forEach(System.out::println);
    }

    public static void rotateA(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            reverse(nums);
        }
    }

    private static void reverse(int[] nums) {
        int temp = nums[nums.length - 1];
        // 从后往前遍历
        for (int i = nums.length - 1; i > 0; i--) {
            // 将当前元素的前一个元素赋值给当前元素
            nums[i] = nums[i - 1];
        }
        // 将最后一个元素赋值给第一个元素
        nums[0] = temp;
    }

    public static void rotateB(int[] nums, int k) {
        if (nums.length == 1) {
            return;
        }
        int[] end = Arrays.stream(nums, 0, nums.length - k).toArray();
        int[] start = Arrays.stream(nums, nums.length - k, nums.length).toArray();
        System.arraycopy(start, 0, nums, 0, start.length);
        System.arraycopy(end, 0, nums, start.length, end.length);
    }


    public static void rotateC(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int num : nums) {
            deque.addLast(num);
        }
        while (k-- >= 0) {
            deque.add(deque.getLast());
        }
    }

    public void rotateD(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}
