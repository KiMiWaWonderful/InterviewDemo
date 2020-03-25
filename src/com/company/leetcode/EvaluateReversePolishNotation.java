package com.company.leetcode;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s: tokens) {
//            if(s == "+" || s == "-" || s == "*" || s == "/") {
//                if(stack.capacity() < 2) {
//                    return 0;
//                }
//                int a = stack.pop();
//                int b = stack.pop();
//                int c = 0;
//                if(s == "+") c = b + a;
//                if(s == "-") c = b - a;
//                if(s == "*") c = b * a;
//                if(s == "/") c = b / a;
//                stack.push(c);
//
//            }else {
//                stack.push(Integer.parseInt(s));
//            }

            try {
                int num = Integer.parseInt(s);
                stack.add(num);
            }catch (Exception e) {
                int b = stack.pop();
                int a = stack.pop();
                stack.add(get(a,b,s));
            }
        }
        return stack.pop();
    }

    private static Integer get(int a, int b, String s) {
        switch (s) {
            case "+" :
                return a + b;
            case "-":
                return a - b;
            case "*" :
                return a * b;
            case "/":
                return a / b;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"4", "13", "5", "/", "+"};
        evalRPN(strings);
    }
}
