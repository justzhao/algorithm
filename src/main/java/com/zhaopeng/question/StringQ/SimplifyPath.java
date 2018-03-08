package com.zhaopeng.question.StringQ;

import java.util.*;

/**
 * https://leetcode.com/problems/simplify-path/description/
 * Created by zhaopeng on 2018/2/14.
 */
public class SimplifyPath {


    /**
     * For example,
     * path = "/home/", => "/home"
     * path = "/a/./b/../../c/", => "/c"
     *
     * @param path
     * @return
     */

    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));

        for (String dir : path.split("/")) {
            // 上一级目录
            if (dir.equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if (!skip.contains(dir)) {
                stack.push(dir);
            }
        }
        String res = "";
        for (String dir : stack) res = "/" + dir + res;
        return res.isEmpty() ? "/" : res;
    }
}
