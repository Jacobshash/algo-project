package com.loltoulan.str;

public class IsPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(1125211));
    }

    public static boolean isPalindrome1(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        String str = x + "";
        char[] charArray = str.toCharArray();
        int i = 0, j = charArray.length - 1;
        while (i < j) {
            char pre = charArray[i];
            char post = charArray[j];
            if (post != pre) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static boolean isPalindrome2(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        String str = x + "";
        int length = str.length();
        String preCharArr;
        String postCharArr;
        if (length % 2 != 0) {
            preCharArr = str.substring(0, (length - 1) / 2);
            postCharArr = str.substring(((length - 1) / 2) +1);
        } else {
            preCharArr = str.substring(0, length / 2);
            postCharArr = str.substring(length / 2);
        }
        StringBuilder stringBuilder = new StringBuilder(postCharArr);
        stringBuilder.reverse();
        return preCharArr.contentEquals(stringBuilder);
    }

    public static boolean isPalindrome(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
