package com.loltoulan.str;

public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        String trim = s.trim();
        int length = 0;
        for (int i = trim.length() - 1; i >= 0; i--) {
            if (!(trim.charAt(i) == ' ')) {
                length++;
            }else {
                break;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        String s = "a";
        System.out.println(lengthOfLastWord(s));
    }

}
