package com.zhaopeng.bean;

/**
 * Created by zhaopeng on 2016/12/6.
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(){

    }
    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
