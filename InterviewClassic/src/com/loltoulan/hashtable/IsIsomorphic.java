package com.loltoulan.hashtable;

public class IsIsomorphic {

    public static void main(String[] args) {
        String s = "egg";
        String t = "add";
        System.out.println(isIsomorphic(s, t));
    }

    public static boolean isIsomorphic(String pattern, String strs) {
        int n = pattern.length();
        if (n != strs.length()) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            char ch = pattern.charAt(i);
            int i2 = pattern.indexOf(ch);
            char o = strs.charAt(i);
            int i1 = strs.indexOf(o);
//            System.out.println(ch + " " + i2 + "  <=====>  " + o + " " + i1);
            if (i2 != i1) {
                return false;
            }
        }
        return true;
    }
}
