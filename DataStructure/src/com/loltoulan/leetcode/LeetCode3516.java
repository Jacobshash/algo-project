package com.loltoulan.leetcode;

public class LeetCode3516 {

    public static int findClosest(int x, int y, int z) {
        if (Math.abs(x - z) == Math.abs(y - z)) {
            return 0;
        }
        return Math.abs(x - z) < Math.abs(y - z) ? 1 : 2;
    }

    public static void main(String[] args) {
        System.out.println(findClosest(1, 2, 3));
    }
}
