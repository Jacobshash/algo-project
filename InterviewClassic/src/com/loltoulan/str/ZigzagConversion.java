package com.loltoulan.str;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 4;
        String ans = convert(s, numRows);
        System.out.println(ans);
    }

    public static String convert(String s, int numRows) {
        char[] charArray = s.toCharArray();
        if (charArray.length == 1) {
            return s;
        }
        if (numRows == 1 || numRows >= charArray.length) {
            return s;
        }
        char[][] chars = new char[numRows][charArray.length];
        int t = numRows + numRows - 2;
        for (int i = 0, high = 0, width = 0; i < charArray.length; ++i) {
            chars[high][width] = s.charAt(i);
            if (i % t < numRows - 1) {
                ++high;
            } else {
                --high; ++width;
            }
        }
        StringBuilder ans = new StringBuilder();
        for (char[] row : chars) {
            for (char ch : row) {
                if (ch != 0) {
                    ans.append(ch);
                }
            }
        }
        return ans.toString();
    }

    public String convert2(String s, int numRows) {
        int n = s.length();
        if (numRows == 1 || numRows >= n) {
            return s;
        }
        int t = numRows * 2 - 2;
        int widt = (n + t - 1) / t * (numRows - 1);
        char[][] mat = new char[numRows][widt];
        for (int i = 0, high = 0, width = 0; i < n; ++i) {
            mat[high][width] = s.charAt(i);
            if (i % t < numRows - 1) {
                ++high;
            } else {
                --high; ++width;
            }
        }
        StringBuilder ans = new StringBuilder();
        for (char[] row : mat) {
            for (char ch : row) {
                if (ch != 0) {
                    ans.append(ch);
                }
            }
        }
        return ans.toString();
    }

    public String convert3(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();

        for(int i=0; i<numRows; i++) {
            rows.add(new StringBuilder());
        }

        int i = 0, flag = -1;

        for(char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i += flag;
        }

        StringBuilder res = new StringBuilder();

        for(StringBuilder row: rows) {
            res.append(row);
        }

        return res.toString();
    }
}

