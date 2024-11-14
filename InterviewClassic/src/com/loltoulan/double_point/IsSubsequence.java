package com.loltoulan.double_point;

public class IsSubsequence {

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        boolean subsequence = isSubsequence(s, t);
        System.out.println(subsequence);
    }

    // 暴力法
    public static boolean isSubsequence(String subStr, String str) {
        if (subStr.isEmpty()) {
            return true;
        }
        if (str.isEmpty()) {
            return false;
        }
        if (subStr.length() > str.length()) {
            return false;
        }
        int index = 0;
        char[] charArray = subStr.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == charArray[index]) {
                index++;
            }
            if (index == charArray.length) {
                return true;
            }
        }
        return false;
    }

}
