package com.loltoulan.stack;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid2("([)]"));
    }

    public static boolean isValid1(String s) {
        if(s.length()%2==1) return false;
        int xl  = 0;
        int xr =0;
        int zl = 0;
        int zr =0;
        int dl = 0;
        int dr = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                xl++;
            }
            if (c == ')') {
                xr++;
            }
            if (c == '[') {
                zl++;
            }
            if (c == ']') {
                zr++;
            }
            if (c == '{') {
                dl++;
            }
            if (c == '}') {
                dr++;
            }
        }
        return xl == xr && zl == zr && dl == dr;
    }
    public static boolean isValid2(String s) {
        if(s.length()%2==1) return false;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if(c=='('){
                stack.push(')');
            }else if(c=='['){
                stack.push(']');
            }else if(c=='{'){
                stack.push('}');
            }else if(stack.isEmpty()||stack.pop()!=c){
                return false;
            }
        }
        return stack.isEmpty();
    }

}
