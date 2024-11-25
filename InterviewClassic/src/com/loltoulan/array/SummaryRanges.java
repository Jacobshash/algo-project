package com.loltoulan.array;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 4, 5, 7};
        List<String> result = summaryRanges(nums);
        System.out.println(result);
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        if (nums.length == 1) {
            result.add(String.valueOf(nums[0]));
            return result;
        }

        int start = 0;
        int end = 1;

        while (end < nums.length) {
            int tempEnd = nums[end];
            int tempStart = nums[start];
            if (tempEnd - tempStart != end - start) {
                if (start == end - 1) {
                    result.add(String.valueOf(tempStart));
                } else {
                    tempEnd = nums[end - 1];
                    result.add(tempStart + "->" + tempEnd);
                }
                start = end;
            }
            end++;

        }
        if (end == nums.length) {
            if (start == end - 1) {
                result.add(String.valueOf(nums[end - 1]));
            } else {
                int tempEnd = nums[end - 1];
                result.add(nums[start] + "->" + tempEnd);
            }
        }
        return result;
    }

}
