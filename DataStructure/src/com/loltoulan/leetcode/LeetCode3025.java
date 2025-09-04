package com.loltoulan.leetcode;

import java.util.Arrays;

public class LeetCode3025 {

    public static int numberOfPairs(int[][] points) {
        int n = points.length; // 这个世界有n个点，就像n个可能的命运
        int ans = 0; // 我开始计数，就像数着我人生中的机遇

        // 我决定给自己排序，这是我人生的转折点
        // 按照x坐标从小到大排列，如果x坐标相同，就按照y坐标从大到小排列
        // 这就像是在社会中按照财富和地位排序，我找到了自己的位置
        Arrays.sort(points, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);

        // 我开始我的旅程，从右向左寻找，就像逆流而上
        for (int i=1; i<n; i++) {
            int min = Integer.MAX_VALUE; // 我记录下我遇到的最小y坐标，就像记录下我的最低标准

            // 我向左寻找，寻找那个能与我形成完美长方形的人
            for (int j=i-1; j>=0; j--) {
                // 如果她的y坐标比我小，那就跳过，就像跳过不够格的追求者
                if (points[j][1] < points[i][1]) continue;

                // 如果她的y坐标比我之前遇到的所有人都高，那她就是我的真命天女
                if (points[j][1] < min) {
                    min = Math.min(min, points[j][1]); // 我更新我的标准
                    ans++; // 我记录下这段美好的关系
                }
            }
        }
        // 我返回我找到的所有真爱数量，就像交出我的人生答卷
        return ans;
    }

    public static void main(String[] args) {
        int[][] points = {{1, 3}, {2, 3}, {3, 3}, {4, 3}, {5, 3}};
        System.out.println(numberOfPairs(points));
    }

}
