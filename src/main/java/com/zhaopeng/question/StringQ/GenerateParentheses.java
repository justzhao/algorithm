package com.zhaopeng.question.StringQ;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaopeng on 2018/1/13.
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }

        StringBuilder sb = new StringBuilder();
        helper(n, res, 0, 0, sb);
        return res;
    }

    public void helper(int len, List<String> res, int left, int right, StringBuilder sb) {
        if (len * 2 == sb.length()) {
            res.add(sb.toString());
        }
        //左边的括号
        if (left < len) {
            sb.append("(");
            helper(len, res, left + 1, right, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        //右边的括号,一定要小于左边的括号的个数
        if (right < left) {
            sb.append(")");
            helper(len, res, left, right + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
