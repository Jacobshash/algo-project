package com.loltoulan.double_point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseWords {

    public static void main(String[] args) {
        String s = "  hello world  ";
        System.out.println(reverseWords(s));
    }

    // 数组翻转
    public static String reverseWords1(String s) {
        if (s.isBlank()) {
            return "";
        }
        String[] words = s.split("\\s+");
        List<String> strings = new ArrayList<>(Arrays.stream(words).toList());
        Collections.reverse(strings);
        return String.join(" ", strings);
    }

    // double point
    public static String reverseWords2(String s) {
        if (s.isBlank()) {
            return "";
        }
        String[] splits = s.trim().split("\\s+");
        int length = splits.length;
        for (int i = 0; i < length / 2; i++) {
            String temp = String.valueOf(splits[i]);
            splits[i] = splits[length - 1 - i];
            splits[length - 1 - i] = temp;
        }
        return String.join(" ", splits);
    }


    public static String reverseWords3(String s) {
        if (s.isBlank()) {
            return "";
        }
        String[] splits = s.split(" ");
        int length = splits.length;
        int lpoint = 0;
        int rpoint = length - 1;
        for (int i = 0; i < length; i++) {


            String ltemp = "";
            String rtemp = "";
            splits[lpoint] = ltemp;

            splits[rpoint] = rtemp;


        }
        return Arrays.stream(splits).filter(str -> !str.isBlank()).collect(Collectors.joining(" "));
    }

    public static String reverseWords(String s) {
        // 将字符串转换为字符数组，以便进行操作
        char[] chars = s.toCharArray();

        // 移除字符串中的多余空格
        int slow = 0; // 慢指针，指向下一个非空格字符应该放置的位置
        //去掉空格操作，然后while循环里面一个单词一个单词赋值
        for (int fast = 0; fast < chars.length; fast++) {
            if (chars[fast] != ' ') { // 快指针找到非空格字符
                if (slow != 0) { // 检查是否需要添加空格，只不在第一个单词前面添加空格
                    chars[slow++] = ' '; // 在单词之间添加一个空格
                }
                //找个一个不为空格的字符后，就开始赋值等到下一个空格字符去掉，然后再赋值
                while (fast < chars.length && chars[fast] != ' ') {
                    chars[slow++] = chars[fast++]; // 复制非空格字符
                }
            }
        }

        // 反转整个字符串
        reverse(chars, 0, slow - 1);

        // 反转每个单词
        int start = 0;
        for (int i = 0; i < slow; i++) {
            if (chars[i] == ' ') {
                reverse(chars, start, i - 1); // 反转单词
                start = i + 1; // 更新下一个单词的开始位置
            }
        }
        // 反转最后一个单词
        reverse(chars, start, slow - 1);

        // 返回结果字符串，注意要截取实际有效的字符长度
        return new String(chars, 0, slow);
    }

    // 辅助函数，用于反转字符数组中的指定部分
    private static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
    }


}
