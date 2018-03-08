package com.zhaopeng.list;

import com.zhaopeng.bean.ListNode;

/**
 * Created by zhaopeng on 2018/2/8.
 */
public class RotateList {

    public static void main(String args[]) {
        RotateList o = new RotateList();

        //  [1,2,3,4,5]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int k = 10;

        ListNode h = o.rotateRight(head, k);
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int len = 1;
        ListNode l = head;
        while (l.next != null) {
            l = l.next;
            len++;
        }
        l.next = head;

        for (int i = 1; i < len - k % len; i++) {
            head = head.next;
        }
        l = head.next;
        head.next = null;
        return l;
    }


    public ListNode reserve(ListNode head, ListNode node) {
        if (head.next == node) {
            return head;
        }
        ListNode next = head.next;

        ListNode newHead = reserve(head.next, node);
        next.next = head;
        head.next = null;
        return newHead;
    }

}
