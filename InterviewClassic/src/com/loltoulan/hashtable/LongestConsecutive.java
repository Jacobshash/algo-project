package com.loltoulan.hashtable;

import java.util.Arrays;

public class LongestConsecutive {
    public static void main(String[] args) {
//        int[] arr = {1,2,0,1};
        int[] arr = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(arr));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        int max = 0;
        int temp = 1;
        Arrays.sort(nums);
        int start = 0;
        int end = 1;
        while (end < nums.length) {
            if (nums[end] == nums[start]) {
                start++;
                end++;
                continue;
            }
            if (nums[end] - nums[start] == 1) {
                start++;
                temp++;
                end++;
            }else{
                start = end;
                end++;
                max = Math.max(max, temp);
                temp = 1;
            }
        }
        max = Math.max(max, temp);
        return max;
    }
}
