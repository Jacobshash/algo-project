package com.loltoulan.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class WordPattern {

    public static void main(String[] args) {
        String pattern = "abbd";
        String str = "dog cat cat dog1";
        System.out.println(wordPattern(pattern, str));
    }

    public static boolean wordPattern1(String pattern, String s) {
        HashMap<String, String> hashMap = new HashMap<>();
        String[] split = s.split(" ");
        if (split.length != pattern.length()) {
            return false;
        }

        for (int i = 0; i < split.length; i++) {
            hashMap.put(String.valueOf(pattern.charAt(i)), split[i]);
        }
        Set<String> strings = hashMap.keySet();
        List<String> values = hashMap.values().stream().distinct().toList();
        if (strings.size() != values.size()) {
            return false;
        }
        for (int i = 0; i < split.length; i++) {
            if (!hashMap.get(String.valueOf(pattern.charAt(i))).equals(split[i])) {
                return false;
            }
        }
        return true;
    }


    public static boolean wordPattern(String pattern, String s) {
        List<String> strs = Arrays.asList(s.split(" "));
        int n = pattern.length();
        if (n != strs.size()) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            char ch = pattern.charAt(i);
            int i2 = pattern.indexOf(ch);
            String o = strs.get(i);
            int i1 = strs.indexOf(o);
            System.out.println(ch + " " + i2 + "  <=====>  " + o + " " + i1);
            if (i2 != i1) {
                return false;
            }
        }
        return true;
    }

}
