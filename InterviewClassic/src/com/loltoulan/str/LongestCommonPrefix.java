package com.loltoulan.str;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"bflower", "afow", "bflight"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        System.out.println(Arrays.toString(strs));
        Arrays.sort(strs);
        System.out.println(Arrays.toString(strs));
        String prefix = strs[0];
        int length = strs.length;

        for (int i = 1; i < length; i++) {
            String str = strs[i];
            prefix = commonPrefix(prefix, str);
        }
        return prefix;
    }

    private static String commonPrefix(String prefix, String str) {
        int min = Math.min(prefix.length(), str.length());
        int index = 0;

        while (index < min && prefix.charAt(index) == str.charAt(index)) {
            index++;
        }

        return prefix.substring(0, index);
    }

}
