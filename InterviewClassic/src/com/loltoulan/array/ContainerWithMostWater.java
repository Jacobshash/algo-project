package com.loltoulan.array;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

    // 暴力求解法
    public static int maxArea1(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int high = Math.min(height[i], height[j]);
                max = Math.max(max, high * (j - i));
            }
        }
        return max;
    }

    // 双指针
    public static int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int width = right - left;
            int high = Math.min(height[left], height[right]);
            max = Math.max(max, width * high);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

}
