package com.loltoulan.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class SimplifyPath {

    public static void main(String[] args) {
        String path = "/a/../../b/d/../c//.//";
        String result = simplifyPath(path);
        System.out.println(result);
    }

    public static String simplifyPath(String path) {
        String[] names = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for (String name : names) {
            if ("..".equals(name)) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else if (!name.isEmpty() && !".".equals(name)) {
                stack.offerLast(name);
            }
        }
        StringBuilder ans = new StringBuilder();
        if (stack.isEmpty()) {
            ans.append('/');
        } else {
            while (!stack.isEmpty()) {
                ans.append('/');
                ans.append(stack.pollFirst());
            }
        }
        return ans.toString();
    }


    private static String simplifyPath12(String path) {
        String[] split = path.split("/");
        Stack<String> stack = new Stack<>();
        stack.push("/");
        for (String s : split) {
            if (s.equals(".") || s.isEmpty()) {
                continue;
            }
            if (!stack.isEmpty() && s.equals("..")) {
                stack.pop();
            } else {
                stack.push(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            if (!s.equals("/") && !s.equals("..")) {
                sb.append(s).append("/");
            }
        }
        if (!sb.isEmpty()) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return "/" + sb;
    }

}
