package com.zhaopeng.question;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * Created by zhaopeng on 2017/12/26.
 */
public class MaxInWindows {

    public static void main(String args[]) {
        //[2,3,4,2,6,2,5,1],3
        MaxInWindows o = new MaxInWindows();
        int nums[] = {2, 3, 4, 2, 6, 2, 5, 1};
        int size = 3;
        System.out.println(o.maxInWindows(nums, size));
    }

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (size <= 0) {
            return res;
        }

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < num.length; i++) {
            if (deque.isEmpty()) {
                deque.offerFirst(i);
            } else {

                if (num[i] >= num[deque.peekFirst()]) {
                    deque.offerFirst(i);
                } else {
                    while (!deque.isEmpty() && num[i] >= num[deque.peekLast()]) {
                        deque.pollLast();
                    }
                    deque.offerLast(i);
                }

                while (i - deque.peekFirst() >= size && !deque.isEmpty()) {
                    deque.pollFirst();
                }
            }
            if (i >= size - 1) {
                res.add(num[deque.peekFirst()]);
            }
        }
        return res;

    }
}
