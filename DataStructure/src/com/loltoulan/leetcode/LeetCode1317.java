package com.loltoulan.leetcode;

public class LeetCode1317 {

    public static int[] getNoZeroIntegers(int n) {
        for (int A = 1; A < n; ++A) {
            int B = n - A;
            if (!String.valueOf(A).contains("0") && !String.valueOf(B).contains("0")) {
                return new int[]{A, B};
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] result = getNoZeroIntegers(101);
        System.out.println(result[0] + " " + result[1]);
    }

}
