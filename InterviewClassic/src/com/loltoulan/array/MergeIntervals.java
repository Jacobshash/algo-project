package com.loltoulan.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 4}, {5, 14}, {15, 18}, {16, 20}};
        int[][] merge = merge(intervals);
        System.out.println(Arrays.deepToString(merge));
    }


    // 官方解法
    public static int[][] merge2(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            int L = interval[0], R = interval[1];
            if (merged.isEmpty() || merged.getLast()[1] < L) {
                merged.add(new int[] {L, R});
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    // 双指针
    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> merged = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int pre = intervals[i][1];
            int j = i + 1;
            while (j < intervals.length && intervals[j][0] <= pre) {
                pre = Math.max(pre, intervals[j][1]);
                j++;
            }
            merged.add(new int[] {intervals[i][0], pre});
            i = j - 1;
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
