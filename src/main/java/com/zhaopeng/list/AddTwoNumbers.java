package com.zhaopeng.list;

import com.zhaopeng.bean.ListNode;

/**
 * https://leetcode.com/problems/add-two-numbers/description/
 * Created by zhaopeng on 2018/1/13.
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode p = l1;
        ListNode head = p;
        while (l1 != null && l2 != null) {
            l1.val += l2.val;
            p = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        //l1 链表先走完了，
        if (l1 == null) {
            p.next = l2;
        }
        p = head;
        ListNode prev = head;
        int preSum = 0;
        while (p != null) {
            p.val += preSum;
            preSum = p.val / 10;
            p.val = p.val % 10;
            prev = p;
            p = p.next;
        }
        while (preSum >= 10) {

            prev.next = new ListNode(preSum % 10);
            prev = prev.next;
            preSum = preSum / 10;
        }
        if (preSum > 0) {
            prev.next = new ListNode(preSum);
        }

        return head;
    }
}
