package com.loltoulan.other;

public class MySqrt {

    public static void main(String[] args) {
        int result = mySqrt(8);
        System.out.println(result);
    }

    public static int mySqrt1(int x) {
       return (int)Math.sqrt(x);
    }


    public static int mySqrt(int x) {
        if (x < 2) {
            return x; // 处理特殊情况 0 和 1
        }
        int left = 1, right = x / 2;
        int result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                result = mid; // 更新结果
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

}
