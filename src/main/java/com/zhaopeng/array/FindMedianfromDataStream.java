package com.zhaopeng.array;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/find-median-from-data-stream/description/
 * Created by zhaopeng on 2018/2/12.
 */
public class FindMedianfromDataStream {

    public static void main(String args[]) {

        FindMedianfromDataStream o = new FindMedianfromDataStream();
        int a[]={4,1,8,9,0,20};
        for(int i:a) {
            o.minHeap.offer(i);
        }
        while (!o.minHeap.isEmpty()){
            System.out.print(o.minHeap.poll()+" ");// 0 1 4 8 9 20
        }
    }

    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(11,new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    }); // 大堆 维护 321
    public PriorityQueue<Integer> minHeap = new PriorityQueue<>();//小堆 维护      45678
    private boolean even = true;

    public double findMedian() {
        // 如果是偶数个数字
        if (even)
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        else
            return maxHeap.peek();
    }

    public void addNum(int num) {
        //如果是偶数
        if (even) {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        } else {
            //如果是奇数
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
        even = !even;
    }
}
