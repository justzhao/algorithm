package com.zhaopeng.question.Normal;

import java.util.Stack;

/**
 * Created by zhaopeng on 2017/5/19.
 */
public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];

            if (s.equals("+")) {
                String a1 = stack.pop();
                String a2 = stack.pop();
                int result = Integer.valueOf(a2) + Integer.valueOf(a1);
                stack.push(String.valueOf(result));


            } else if (s.equals("-")) {
                String a1 = stack.pop();
                String a2 = stack.pop();
                int result = Integer.valueOf(a2) - Integer.valueOf(a1);
                stack.push(String.valueOf(result));

            } else if (s.equals("*")) {
                String a1 = stack.pop();
                String a2 = stack.pop();
                int result = Integer.valueOf(a2) * Integer.valueOf(a1);
                stack.push(String.valueOf(result));
            } else if (s.equals("/")) {
                String a1 = stack.pop();
                String a2 = stack.pop();
                int result = Integer.valueOf(a2) / Integer.valueOf(a1);
                stack.push(String.valueOf(result));
            } else{

                stack.push(s);

            }

        }

        String result = stack.pop();
        return Integer.valueOf(result);
    }


    public static void main(String args[]) {
//["0","3","/"]
        String tokes[] = new String[3];
        tokes[0] = "0";
        tokes[1] = "3";
        tokes[2] = "/";

        EvaluateReversePolishNotation m = new EvaluateReversePolishNotation();

        System.out.println(m.evalRPN(tokes));
    }

}
