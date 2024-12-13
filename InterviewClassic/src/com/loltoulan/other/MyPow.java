package com.loltoulan.other;

public class MyPow {

    public static void main(String[] args) {
        double pow = myPow(-2.00000, 10);
        System.out.println(pow);
    }

    public static double myPow(double x, int n) {

        if (x == 0) {
            return 0;
        }
        if (x == 1 || x == -1) {
            if (n % 2 == 0) {
                return 1;
            }else {
                return x;
            }
        }
        if (n == -2147483648) {
            return 0;
        }
        double temp = Math.abs(n);
        double result = 1;
        while (temp > 0) {
            result *= x;
            temp--;
        }
        if (n > 0) {
            return result;
        } else {
            return 1 / result;
        }
    }

    public static double myPow2(double x, int n) {
        return Math.pow(x, n);
    }

    public static double myPow1(double x, int n) {
        return (long)n >= 0 ? quickMul1(x, n) : 1.0 / quickMul1(x, -(long)n);
    }

    public static double quickMul1(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    public static double myPow3(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public static double quickMul(double x, long N) {
        double ans = 1.0;
        // 贡献的初始值为 x
        double x_contribute = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (N > 0) {
            if (N % 2 == 1) {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                ans *= x_contribute;
            }
            // 将贡献不断地平方
            x_contribute *= x_contribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            N /= 2;
        }
        return ans;
    }

}
