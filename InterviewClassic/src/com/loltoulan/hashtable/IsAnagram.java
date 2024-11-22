package com.loltoulan.hashtable;

import java.util.Arrays;

public class IsAnagram {

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        boolean result = isAnagram(s, t);
        System.out.println(result);
    }

    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    public static boolean isAnagram(String s, String t) {

        if (t.length()!= s.length()) {
            return false;
        }
        int[] hash = new int[26];
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            hash[c - 'a']++;
        }

        char[] tCharArray = t.toCharArray();
        for (char c : tCharArray) {
            hash[c - 'a']--;
            if (hash[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

}
