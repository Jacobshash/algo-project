package com.loltoulan.other;

public class AddBinary {

    public static void main(String[] args) {
        String b =  "1";
        String a = "11";
        System.out.println(addBinary(a, b));
    }

    public static String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int n = Math.max(a.length(), b.length()), pre = 0;
        int d = 999999999;
        for (int i = 0; i < n; ++i) {
            pre += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            pre += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (pre % 2 + '0'));
            pre /= 2;
        }
        if (pre == 1) {
            ans.append(pre);
        }
        return ans.reverse().toString();
    }

}
