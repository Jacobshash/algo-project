package com.loltoulan.dynamic_programming;

public class ClimbStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }

    public static int climbStairs1(int n){
        return switch (n) {
            case 1 -> 1;
            case 2 -> 2;
            case 3 -> 3;
            case 4 -> 5;
            case 5 -> 8;
            case 6 -> 13;
            case 7 -> 21;
            case 8 -> 34;
            case 9 -> 55;
            case 10 -> 89;
            case 11 -> 144;
            case 12 -> 233;
            case 13 -> 377;
            case 14 -> 610;
            case 15 -> 987;
            case 16 -> 1597;
            case 17 -> 2584;
            case 18 -> 4181;
            case 19 -> 6765;
            case 20 -> 10946;
            case 21 -> 17711;
            case 22 -> 28657;
            case 23 -> 46368;
            case 24 -> 75025;
            case 25 -> 121393;
            case 26 -> 196418;
            case 27 -> 317811;
            case 28 -> 514229;
            case 29 -> 832040;
            case 30 -> 1346269;
            case 31 -> 2178309;
            case 32 -> 3524578;
            case 33 -> 5702887;
            case 34 -> 9227465;
            case 35 -> 14930352;
            case 36 -> 24157817;
            case 37 -> 39088169;
            case 38 -> 63245986;
            case 39 -> 102334155;
            case 40 -> 165580141;
            case 41 -> 267914296;
            case 42 -> 433494437;
            case 43 -> 701408733;
            case 44 -> 1134903170;
            case 45 -> 1836311903;
            default -> 0;
        };
    }

    public static int climbStairs(int n){
        if (n <= 2) {
            return n;
        }
        // f(n) = f(n-1)+f(n-2)
        int result = 0;
        int n_1 = 2;
        int n_2 = 1;
        for (int i = 3; i <= n; i++) {
            result = n_1 + n_2;
            n_2 = n_1;
            n_1 = result;
        }
        return result;
    }

}
