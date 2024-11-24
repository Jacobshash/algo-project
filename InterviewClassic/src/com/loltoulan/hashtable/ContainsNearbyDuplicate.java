package com.loltoulan.hashtable;

import java.util.*;

public class ContainsNearbyDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        System.out.println(containsNearbyDuplicate(nums, k));
    }


    public static boolean containsNearbyDuplicate1(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            int target = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int temp = nums[j];
                if (target == temp && Math.abs(i - j) <= k) {
                   return true;
                }
            }
        }
        return false;
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> orDefault = hashMap.getOrDefault(nums[i], new ArrayList<>());
            if (!orDefault.isEmpty()) {
                for (Integer integer : orDefault) {
                    if (Math.abs(i - integer) <= k) {
                        return true;
                    }
                }
            }
            orDefault.add(i);
            hashMap.put(nums[i], orDefault);
        }
        return false;
    }

}
