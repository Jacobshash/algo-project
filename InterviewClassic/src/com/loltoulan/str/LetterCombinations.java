package com.loltoulan.str;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinations {

    public static void main(String[] args) {
        String digits = "2345";
        List<String> result = letterCombinations(digits);
        for (String s : result) {
            System.out.println(s);
        }
        System.out.println(result.size());
    }

    public static List<String> letterCombinationsNoRecursion(String digits) {
        if (digits.isEmpty()) {
            return List.of();
        }
        char[] charArray = digits.toCharArray();
        List<String> result = hashMap.get(charArray[0]);
        int length = digits.length();
        if (length == 1) {
            return result;
        }
        int i = 1;
        while (i < length){
            List<String> temp = new ArrayList<>();
            for (String s1 : result) {
                for (String s2 : hashMap.get(charArray[i])) {
                    temp.add(s1+s2);
                }
            }
            result = temp;
            i++;
        }
        return result;
    }

    static HashMap<Character, List<String>> hashMap = new HashMap<>();
    static {
        hashMap.put('2', List.of("a", "b", "c"));
        hashMap.put('3', List.of("d", "e", "f"));
        hashMap.put('4', List.of("g", "h", "i"));
        hashMap.put('5', List.of("j", "k", "l"));
        hashMap.put('6', List.of("m", "n", "o"));
        hashMap.put('7', List.of("p", "q", "r", "s"));
        hashMap.put('8', List.of("t", "u", "v"));
        hashMap.put('9', List.of("w", "x", "y", "z"));
    }

    public static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return List.of();
        }
        char[] charArray = digits.toCharArray();
        List<String> result = hashMap.get(charArray[0]);
        int length = digits.length();
        if (length == 1) {
            return result;
        }
        return combine(1, digits,digits.length(), result);
    }

    private static List<String> combine(int i, String digits, int length, List<String> result) {
        if (i == length) {
            return result;
        }
        List<String> re = new ArrayList<>();
        List<String> strings = hashMap.get(digits.charAt(i));
        for (String s : result) {
            for (String string : strings) {
                re.add(s + string);
            }
        }
        return combine(++i, digits, length, re);
    }


}
