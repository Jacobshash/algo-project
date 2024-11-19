package com.loltoulan.array;

public class TwoSumII {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] ints = twoSum(nums, target);
        if (ints == null) {
            return;
        }
        System.out.println(ints[0] + " " + ints[1]);
    }


    // 暴力解法
    public static int[] twoSum1(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int tar = target - numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] == tar) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return null;
    }


    // 双指针
    public static int[] twoSum2(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            if (left == right) {
                left--;
            }
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            }
            if (numbers[left] + numbers[right] > target) {
                right--;
            }
            if (numbers[left] + numbers[right] < target) {
                left++;
            }
        }
        return null;
    }

    // 二分法
    public static int[] twoSum(int[] numbers, int target) {
       for (int i = 0; i < numbers.length; ++i) {
            int low = i, high = numbers.length - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] > target - numbers[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return null;
    }

}
