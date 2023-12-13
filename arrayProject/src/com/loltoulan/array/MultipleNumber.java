package com.loltoulan.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MultipleNumber {

    public static void main(String[] args) {
        int majorityElement = majorityElementB(new int[]{2, 2, 1, 1, 1, 2, 2});
        System.out.println(majorityElement);
    }

    public static int majorityElementA(int[] nums) {
        Map<Integer, Integer> integerHashMap = new HashMap<>();
        for (int num : nums) {
            if (integerHashMap.containsKey(num)) {
                integerHashMap.put(num, integerHashMap.get(num) + 1);
            } else {
                integerHashMap.put(num, 1);
            }
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : integerHashMap.entrySet()) {
            Integer k = entry.getKey();
            Integer v = entry.getValue();
            if (v > nums.length / 2) {
                res = k;
            }
        }
        return res;
    }

    public static int majorityElementB(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }


}
