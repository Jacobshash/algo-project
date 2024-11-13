package com.loltoulan.str;

public class KmpStrMatchFirst {

    public static void main(String[] args) {
//        System.out.println(strStr("mississippi", "issip"));
//        System.out.println(strStr("a", "a"));
//        System.out.println(strStr("", "a"));
//        System.out.println(strStr("", ""));
//        System.out.println(strStr("aaa", "aaaa"));
//        System.out.println(strStr("aaaaa", "bba"));
//        System.out.println(strStr("ababac", "ababa"));
        System.out.println(strStr("abc", "c"));
    }

    public static int strStr(String haystack, String needle) {
        char[] haystackArray = haystack.toCharArray();
        char[] needleArray = needle.toCharArray();
        if (needleArray.length == 0) {
            return 0;
        }
        if (haystackArray.length == needleArray.length && needle.equals(haystack)) {
            return 0;
        }
        if (needleArray.length > haystackArray.length) {
            return -1;
        }
        int index = -1;

        for (int i = 0; i < haystackArray.length; i++) {
            int littleIndex = i;
            if (littleIndex > haystackArray.length - needleArray.length) {
                return -1;
            }
            for (int j = 0; j < needleArray.length; j++) {
                if (haystackArray[littleIndex] == needleArray[j]) {
                    if (j == 0) {
                        index = littleIndex;
                    }
                    littleIndex++;
                    if (j == needleArray.length-1) {
                        return index;
                    }
                }else {
                    break;
                }
            }
        }
        return index;
    }

}
