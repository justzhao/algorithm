package com.zhaopeng.list;

import com.zhaopeng.bean.ListNode;

/**
 * Created by zhaopeng on 2018/2/9.
 */
public class RemoveDuplicatesfromSortedList {


    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = head;

        ListNode node = head.next;
        while (node != null) {
            if (pre.val == node.val) {
                pre.next = node.next;
            } else {
                pre = node;
            }
            node = node.next;
        }
        return head;
    }
}
