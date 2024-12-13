package com.loltoulan.other;

import java.math.BigInteger;
import java.util.Objects;

public class TrailingZeroes {

    public static void main(String[] args) {
        System.out.println(trailingZeroes(5));
    }

    public static int trailingZeroes1(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            BigInteger bigInteger = BigInteger.valueOf(i);
            result = result.multiply(bigInteger);
        }
        String string = result.toString();
        int zeros = 0;
        for (int i = string.length() - 1; i >= 0; i--) {
            if (Objects.equals(string.charAt(i), '0')) {
                zeros++;
            }else {
                return zeros;
            }
        }
        return zeros;
    }

    public static int trailingZeroes(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int N = i;
            while (N > 0) {
                if (N % 5 == 0) {
                    count++;
                    N /= 5;
                } else {
                    break;
                }
            }
        }
        return count;
    }

}
