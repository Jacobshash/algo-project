package com.loltoulan.hashtable;


import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public int romanToInt1(String s) {
        s = s.replace("IV","a");
        s = s.replace("IX","b");
        s = s.replace("XL","c");
        s = s.replace("XC","d");
        s = s.replace("CD","e");
        s = s.replace("CM","f");
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("a", 4);
        map.put("b", 9);
        map.put("c", 40);
        map.put("d", 90);
        map.put("e", 400);
        map.put("f", 900);
        if (map.containsKey(s)) {
            return map.get(s);
        }
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += map.get(s.substring(i, i + 1));
        }
        return sum;
    }





    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if(i<n-1 && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))){
                ans -= map.get(s.charAt(i));
            }else {
                ans += map.get(s.charAt(i));
            }
        }
        return ans;
    }


}
