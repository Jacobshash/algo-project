package com.loltoulan.dynamic_programming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public static void main(String[] args) {
        String s = "cars";
        List<String> wordDict = List.of("car", "ca", "rs");
        System.out.println(wordBreak2(s, wordDict));
        WordBreak wordBreak = new WordBreak();
        System.out.println(wordBreak.wordBreak(s, wordDict));
    }


    public static boolean wordBreak2(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];    // 便于判断无前缀子串的情况
        dp[0] = true;
        Set<String> set = new HashSet<>(wordDict);  // 便于判断是否存在
        for (int i = 1; i <= n; ++i) {    // 跟着dp做相应修改
            for (int j = 0; j < i; ++j) { // j=0是为了无前缀子串的特殊情况, j<i是考虑所有前缀子串情况
                if (dp[j] && set.contains(s.substring(j, i))) {   // substring(j,i)，j是因为string下标从0开始，i是因为for中i从1开始
                    dp[i] = true;
                    break;  // 可以拼接出
                } else
                    dp[i] = false;
            }
        }
        return dp[n];
    }

    // 这里的缓存表示，在以 index 为起点的字符串，是否不能继续拆分为字典内的组合值，为 true 时代表不能
    private boolean[] cache;
    public boolean wordBreak(String s, List<String> wordDict) {
        cache = new boolean[s.length()];
        return tryMatch(s, 0, wordDict);
    }

    private boolean tryMatch(String src, int start, List<String> wordDict){
        if(cache[start]){
            return false;
        }
        for(int i = 0; i < wordDict.size(); i++){
            if(isMatch(src, start, wordDict.get(i))){
                cache[start] = true;
                int nextStart = start + wordDict.get(i).length();
                if(nextStart == src.length()){
                    return true;
                }else{
                    // 这里如果递归出一个正确结果，可以直接返回，否则需要等剩下的遍历结果
                    boolean result = tryMatch(src, nextStart, wordDict);
                    if(result){
                        return true;
                    }
                }
            }
        }
        cache[start] = true;
        return false;
    }

    private boolean isMatch(String src, int start, String word){
        if(word.length() > src.length() - start){
            return false;
        }
        for(int i = start; i < src.length() && i - start < word.length(); i++){
            if(src.charAt(i) != word.charAt(i - start)){
                return false;
            }
        }
        return true;
    }

}
