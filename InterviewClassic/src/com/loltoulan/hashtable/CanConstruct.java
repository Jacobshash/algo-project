package com.loltoulan.hashtable;

import java.util.List;

public class CanConstruct {

    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "ba";
        System.out.println(canConstruct(ransomNote, magazine));
    }

    public static boolean canConstruct1(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        if (magazine.contains(ransomNote)) {
            return true;
        }
        List<String> ransomNoteList = ransomNote.chars()  // 转换为 IntStream
                .mapToObj(c -> (char) c)  // 将 int 转回 char
                .map(String::valueOf)
                .toList();  // 收集到 List 中

        List<String> magazineList = new java.util.ArrayList<>(magazine.chars()  // 转换为 IntStream
                .mapToObj(c -> (char) c)  // 将 int 转回 char
                .map(String::valueOf)
                .toList());  // 收集到 List 中
        for (String s : ransomNoteList) {
            if (magazineList.contains(s)) {
                magazineList.remove(s);
            } else {
                return false;
            }
        }
        return false;
    }

    public static boolean canConstruct2(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        if (magazine.contains(ransomNote)) {
            return true;
        }
        for (char s : magazine.toCharArray()) {
            ransomNote = ransomNote.replaceFirst(String.valueOf(s), "");
        }
        return ransomNote.isEmpty();
    }

    // 我提交的方法， 虽然可以运行， 但速度很慢， 也能过， 时间是 16ms，  题解上的最快的是 1ms， 比我的快了16倍
    // 它没用哈希， 而是巧妙的用了数组 记录， 找一下个同样的字符应该从哪开始找才算，我自己是是纸上演练了一下才知的
    // 由于都是字母， 这个是题目 说的， 小写字母， 所以数组长度为  26 即可
    // 方法中 巧妙用到，  String的  indexOf(ch, fromIndex)  , 这个方法我几乎没用到过， 它表示的意思， 就是从哪开始找字符
    //   找到返回  ch  从  0 开始的位置 ， 如  为  pos， 如果 fromIndex   大于  pos， 从它开始找是找不到的， 返回  -1,
    //  要利用这个特性的。

    //  所以这里有两个知识点是前提 ，  整形数组， 没有初始化， 每个元素初始为0；  indexOf(ch,fromIndex)的用法
    //  利用 26个元素数组 来表示它是哪个字母， 它的元素值表示要从哪个位置开始查找。

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26]; // 这个数组记录， 对应的字母下次要从magazine哪个位置开始找， 因为用过的，就不能再用
        int index = 0, start = 0, next = 0;
        char ch;
        for (int i = 0; i < ransomNote.length(); i++) {
            ch = ransomNote.charAt(i);
            index = ch - 'a';
            start = arr[index];
            next = magazine.indexOf(ch, start);
            if (next == -1) {
                return false;  // 没找到直接返回
            }
            arr[index] = next + 1;  // 更新下一次， 找对应字母需要开始的位置。
        }
        return true;
    }

}
