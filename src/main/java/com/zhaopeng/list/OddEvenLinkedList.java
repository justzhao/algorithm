package com.zhaopeng.list;

import com.zhaopeng.bean.ListNode;

/**
 * https://leetcode.com/problems/odd-even-linked-list/discuss/
 * Created by zhaopeng on 2018/1/19.
 */
public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            even.next = even.next.next;
            even = even.next;
            odd = odd.next;
        }
        odd.next = evenHead;

        return head;
    }
}
