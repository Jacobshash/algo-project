package com.loltoulan.array;

import java.util.Arrays;

public class PlusOne {

    public static void main(String[] args) {
        int[] digits = {9,9,9,9};
        int[] result = plusOne(digits);
        for (int i : result) {
            System.out.print(i);
        }
    }

    public static int[] plusOne(int[] digits) {
        int[] result = new int[digits.length + 1];
        int add = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int item = digits[i] + add;
            if (item >= 10) {
                add = 1;
                item = item % 10;
            }else {
                add = 0;
            }
            result[i+1] = item;
        }
        if (result[0] == 0 && add == 1) {
            result[0] = add;
        }
        if (result[0] == 0) {
            return Arrays.copyOfRange(result, 1, result.length);
        }
        return result;
    }

}
