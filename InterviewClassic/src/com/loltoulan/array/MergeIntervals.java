package com.loltoulan.array;

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{18,20},{15,18}};
        int[][] merge = merge(intervals);
        System.out.println(Arrays.deepToString(merge));
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[][] res = new int[intervals.length][2];
        int startStart = 0;

        int endStart = 1;
        while (endStart < intervals.length) {
            int startStartValue = intervals[startStart][0];
            int startEndValue = intervals[startStart][1];

            int endStartValue = intervals[endStart][0];
            int endEndValue = intervals[endStart][0];

            // if(){
            //
            // }

        }
        return res;
    }
}
