package com.zhaopeng.list;

import com.zhaopeng.bean.ListNode;

/**
 * Created by zhaopeng on 2017/6/22.
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode p = head;
        ListNode q = head;
        while (p != null) {
            p = p.next;
            q = q.next;
            if (p == null || q == null) {
                return false;
            }
            p = p.next;
            if (p == q) {
                return true;
            }
        }
        return false;

    }


}
