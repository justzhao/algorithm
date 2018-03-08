package com.zhaopeng.list;

import com.zhaopeng.bean.ListNode;

/**
 * Created by zhaopeng on 2018/2/21.
 */
public class RemoveDuplicatesfromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) return null;
        if (head.next != null && head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
        }
        return head;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null) return null;
        ListNode FakeHead = new ListNode(0);
        FakeHead.next = head;
        ListNode pre = FakeHead;
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            if (pre.next == cur) {
                pre = pre.next;
            } else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return FakeHead.next;
    }
}
