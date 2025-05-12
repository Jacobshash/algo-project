package com.loltoulan.pandas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindThreeEvenDigit {

    public static void main(String[] args) {
        int[] digits = {2, 2, 8, 8, 2};
        System.out.println(Arrays.toString(findEvenNumbers2(digits)));
    }

    public static int[] findEvenNumbers1(int[] digits) {
        boolean flag = false;
        for (int digit : digits) {
            if (digit % 2 == 0) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            return new int[]{};
        }
        List<Integer> integers = generateNumbers(digits, 3).stream().distinct().sorted().toList();
        List<Integer> result = new ArrayList<>();
        integers.forEach(integer -> {
            if (integer % 2 == 0) {
                result.add(integer);
            }
        });
        int[] resultArray = new int[result.size()];
        result.forEach(integer -> resultArray[result.indexOf(integer)] = integer);
        return resultArray;
    }

    public static List<Integer> generateNumbers(int[] digits, int n) {
        List<Integer> result = new ArrayList<>();
        boolean[] used = new boolean[digits.length];
        backtrack(digits, n, 0, used, new StringBuilder(), result);
        return result;
    }

    private static void backtrack(int[] digits,
                                  int n,
                                  int pos,
                                  boolean[] used,
                                  StringBuilder sb,
                                  List<Integer> result) {
        if (pos == n) {
            result.add(Integer.parseInt(sb.toString()));
            return;
        }

        for (int i = 0; i < digits.length; i++) {
            if (used[i]) {
                continue;
            }

            // 百位不能为0（如果是三位数）
            if (pos == 0 && digits[i] == 0) {
                continue;
            }

            used[i] = true;
            sb.append(digits[i]);
            backtrack(digits, n, pos + 1, used, sb, result);
            sb.deleteCharAt(sb.length() - 1);
            used[i] = false;
        }
    }

    public static int[] findEvenNumbers2(int[] digits) {
        int[] cnt = new int[10];
        for (int d : digits) {
            cnt[d]++;
        }

        List<Integer> ans = new ArrayList<>();
        dfs(0, 0, cnt, ans);
        return ans.stream().mapToInt(i -> i).toArray();
    }

    // i=0 百位，i=1 十位，i=2 个位，x 表示当前正在构造的数字
    private static void dfs(int i, int x, int[] cnt, List<Integer> ans) {
        if (i == 3) {
            ans.add(x);
            return;
        }
        for (int d = 0; d < 10; d++) {
            if (cnt[d] > 0 && (i == 0 && d > 0 || i == 1 || i == 2 && d % 2 == 0)) {
                cnt[d]--; // 消耗一个数字 d
                dfs(i + 1, x * 10 + d, cnt, ans);
                cnt[d]++; // 复原
            }
        }
    }

}


