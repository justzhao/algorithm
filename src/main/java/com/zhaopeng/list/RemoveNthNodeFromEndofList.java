package com.zhaopeng.list;

import com.zhaopeng.bean.ListNode;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 * Created by zhaopeng on 2018/1/7.
 */
public class RemoveNthNodeFromEndofList {

    public static void main(String args[]) {
        RemoveNthNodeFromEndofList o = new RemoveNthNodeFromEndofList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        int n = 2;

        System.out.println(o.removeNthFromEnd(head, n));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode h=new ListNode(-1);
        h.next=head;
        ListNode fast = h;
        ListNode slow = h;

        while (fast.next != null) {
            if(n <= 0)
                slow = slow.next;

            fast = fast.next;
            n--;
        }

        if(slow.next != null) {
            slow.next = slow.next.next;
        }
        return h.next;
    }

}
