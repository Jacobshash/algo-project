package com.loltoulan.str;

public class ValidPalindrome {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));

    }

    public static boolean isPalindrome(String s) {
        String result = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        if(result.length() <= 1){
            return true;
        }
        char[] charArray = result.toCharArray();
        for (int i = 0, j = charArray.length - 1; i < j; ++i, --j) {
            if (charArray[i] != charArray[j]) {
                return false;
            }
        }
        return true;
    }

}
