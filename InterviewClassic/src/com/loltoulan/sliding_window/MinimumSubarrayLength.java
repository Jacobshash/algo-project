package com.loltoulan.sliding_window;

public class MinimumSubarrayLength {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println(minimumSubarrayLength2(nums, target));
    }

    public static int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int value = 0;
            for (int j = i; j < n; j++) {
                value |= nums[j];
                if (value >= k) {
                    res = Math.min(res, j - i + 1);
                    break;
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static int minimumSubarrayLength2(int[] nums, int k) {
        int n = nums.length;
        int[] bits = new int[30];
        int res = Integer.MAX_VALUE;
        for (int left = 0, right = 0; right < n; right++) {
            for (int i = 0; i < 30; i++) {
                bits[i] += (nums[right] >> i) & 1;
            }
            while (left <= right && calc(bits) >= k) {
                res = Math.min(res, right - left + 1);
                for (int i = 0; i < 30; i++) {
                    bits[i] -= (nums[left] >> i) & 1;
                }
                left++;
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private static int calc(int[] bits) {
        int ans = 0;
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] > 0) {
                ans |= 1 << i;
            }
        }
        return ans;
    }

}
