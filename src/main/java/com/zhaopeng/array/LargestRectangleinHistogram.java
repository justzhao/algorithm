package com.zhaopeng.array;

import java.util.Stack;

/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 * Created by zhaopeng on 2018/1/6.
 */
public class LargestRectangleinHistogram {


    /**
     * 新建一个栈，索引进栈。当发现heights[i]比栈顶元素对应的heights 小的时候，记录当前index
     * 栈头元素出栈，然后开始计算最大面积，
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {

        if (heights == null || heights.length == 0) {
            return 0;
        }
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        //i<=length是防止 出现heights 一直递增的情况
        for (int i = 0; i <= heights.length; i++) {
            int h = i == heights.length ? 0 : heights[i];
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int end = i;
                int height = heights[stack.pop()];
                //栈空了为什么是-1， 因为栈空了，表示前面比较大高度的已经计算完了。
                int start = stack.isEmpty() ? -1 : stack.peek();
                res = Math.max(res, (end - start - 1) * height);
            }
            stack.push(i);
        }
        return res;
    }
}
