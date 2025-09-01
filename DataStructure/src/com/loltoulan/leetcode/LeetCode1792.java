package com.loltoulan.leetcode;

import java.util.PriorityQueue;

public class LeetCode1792 {

    public static double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            double x1 = ((a[0] + 1) / (double) (a[1] + 1)) - (a[0] / (double) a[1]);
            double x2 = ((b[0] + 1) / (double) (b[1] + 1)) - (b[0] / (double) b[1]);
            return Double.compare(x2, x1);
        });
        for (int[] c : classes) {
            pq.offer(c);
        }
        while (extraStudents-- > 0) {
            int[] c = pq.poll();
            c[0]++;
            c[1]++;
            pq.offer(c);
        }
        double sum = 0;
        while (!pq.isEmpty()) {
            int[] c = pq.poll();
            sum += (double) c[0] / c[1];
        }
        return sum / classes.length;
    }


    public static void main(String[] args) {
        int[][] classes = {{1, 2}, {3, 5}, {2, 2}};
        int extraStudents = 2;
        System.out.println(maxAverageRatio(classes, extraStudents));
    }
}
