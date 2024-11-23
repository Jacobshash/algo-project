package com.loltoulan.hashtable;

import java.util.ArrayList;
import java.util.List;

public class IsHappy {

    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }

    public static boolean isHappy(int n) {
        List<Integer> integers = new ArrayList<>();
        int sum = n;
        while (true) {
            integers.add(sum);
            int tempSum = aaa(sum);

            if (tempSum == 1) {
                return true;
            }else if (integers.contains(tempSum)) {
                return false;
            } else {
                sum = tempSum;
            }
        }
    }

    private static int aaa(int sum) {
        List<Integer> integers = intToListOfInts(sum);
        sum = 0;
        for (Integer integer : integers) {
            sum += (int) Math.pow(integer, 2);
        }
        return sum;
    }

    public static List<Integer> intToListOfInts(int number) {
        List<Integer> list = new ArrayList<>();
        while (number > 0) {
            list.add(0, number % 10); // 插入到列表开头
            number /= 10;
        }
        return list;
    }


}
