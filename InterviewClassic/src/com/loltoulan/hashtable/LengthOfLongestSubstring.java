package com.loltoulan.hashtable;

import java.util.ArrayList;
import java.util.List;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = " ";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        int max = -1;
        int end = 0;
        List<Character> list = new ArrayList<>();
        while (end < s.length()) {
            if (!list.contains(s.charAt(end))) {
                list.add(s.charAt(end));
                end++;
            }else{
                max = Math.max(max, list.size());
                list.remove(0);
            }
        }
        max = Math.max(max, list.size());
        return max;
    }
}
