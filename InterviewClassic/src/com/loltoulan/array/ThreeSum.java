package com.loltoulan.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {1, 1, -2};
        int target = 0;
        System.out.println(threeSum(nums, target));
//        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums, int target) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        List<Integer> list = Arrays.stream(nums).boxed().sorted().distinct().toList();
        if (list.size() == 1 && list.get(0) == target) {
            return List.of(Arrays.asList(0, 0, 0));
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int size = nums.length - 1; size > 0; size--) {
            int left = 0;
            int right = size - 1;
            int current = nums[size];
            while (left < right) {
                int sum = current + nums[left] + nums[right];
                if (sum == target) {
                    result.add(Arrays.asList(nums[left], nums[right], current));
                    right--;
                }
                if (sum < target) {
                    left++;
                }
                if (sum > target) {
                    right--;
                }
            }
        }
        return result.stream().distinct().toList();
    }


    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3 || nums.length > 30000) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        // int[] nums = {0,0,0,0,0};
        for (int i = 0, len = nums.length; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[right] + nums[left] + nums[i];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum > 0) right--;
                else left++;

            }
        }
        return list;
    }
}
