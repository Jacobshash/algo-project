package com.loltoulan.hashtable;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(strs);
        System.out.println(result);
    }

    public static List<List<String>> groupAnagrams1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        List<List<String>> results = new ArrayList<>();
        if (strs.length == 1) {
            results.add(Collections.singletonList(strs[0]));
            return results;
        }
        int start = 0;
        while (start < strs.length) {
            if (strs[start] == null) {
                start++;
                continue;
            }
            List<String> list = new ArrayList<>();
            list.add(strs[start]);
            String startStr = strs[start];

            char[] charArray = startStr.toCharArray();
            Arrays.sort(charArray);
            for (int i = start + 1; i < strs.length; i++) {
                if (strs[i] == null) {
                    continue;
                }
                String endStr = strs[i];
                char[] endStrCharArray = endStr.toCharArray();
                Arrays.sort(endStrCharArray);
                if (Arrays.equals(charArray, endStrCharArray)) {
                    list.add(endStr);
                    strs[i] = null;
                }
            }
            strs[start] = null;
            results.add(list);
            start++;
        }
        return results;
    }

    public static List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> results = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        if (strs.length == 1) {
            results.add(Collections.singletonList(strs[0]));
            return results;
        }
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortStr = Arrays.toString(charArray);
            if (hashMap.containsKey(sortStr)) {
                List<String> strings = hashMap.get(sortStr);
                strings.add(str);
            }else {
                hashMap.put(sortStr, new ArrayList<>(Collections.singletonList(str)));
            }
        }
        return new ArrayList<>(hashMap.values());
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> results = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        if (strs.length == 1) {
            results.add(Collections.singletonList(strs[0]));
            return results;
        }
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortStr = Arrays.toString(charArray);
            List<String> strings = hashMap.getOrDefault(sortStr, new ArrayList<>());
            strings.add(str);
            hashMap.put(sortStr, strings);
        }
        return new ArrayList<>(hashMap.values());
    }

}
