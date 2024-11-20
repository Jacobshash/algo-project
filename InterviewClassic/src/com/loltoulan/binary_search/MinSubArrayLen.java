package com.loltoulan.binary_search;

import java.util.Arrays;

public class MinSubArrayLen {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println(minSubArrayLen(target, nums));
    }

    // 暴力解法
    public static int minSubArrayLen1(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum >= target) {
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    // 滑动窗口
    public static int minSubArrayLen2(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int start = 0, end = 0;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        while (end < n) {
            sum = sum + nums[end];
            if (sum >= target) {
                ans = Math.min(ans, (end - start) + 1);
                sum = sum - nums[start] - nums[end];
                ++start;
            } else {
                ++end;
            }

        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


    // 前缀和
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // 前缀和
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        for (int i = 1; i <= n; i++) {
            int sum = sums[i-1] + target;
            int bound = Arrays.binarySearch(sums, sum);
            if (bound < 0) {
                bound = -bound - 1; // 转换为插入点
            }
            if (bound <= n) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

}






























