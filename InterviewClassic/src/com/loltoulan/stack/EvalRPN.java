package com.loltoulan.stack;

import java.util.Stack;

public class EvalRPN {

    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                Integer pop1 = stack.pop();
                Integer pop2 = stack.pop();
                stack.push(pop2 + pop1);
                continue;
            }
            if (token.equals("-")) {
                Integer pop1 = stack.pop();
                Integer pop2 = stack.pop();
                stack.push(pop2 - pop1);
                continue;
            }
            if (token.equals("*")) {
                Integer pop1 = stack.pop();
                Integer pop2 = stack.pop();
                stack.push(pop2 * pop1);
                continue;
            }
            if (token.equals("/")) {
                Integer pop1 = stack.pop();
                Integer pop2 = stack.pop();
                stack.push(pop2 / pop1);
                continue;
            }
            stack.push(Integer.parseInt(token));
        }
        return stack.pop();
    }

    public int evalRPN2(String[] tokens) {
        index = tokens.length - 1;
        return recursive(tokens);
    }

    private int index;

    private int recursive(String[] tokens) {
        String s = tokens[index--];
        if (!("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s))) return Integer.parseInt(s);
        int b = recursive(tokens);
        int a = recursive(tokens);
        switch (s) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
        }
        return 0;
    }

}
