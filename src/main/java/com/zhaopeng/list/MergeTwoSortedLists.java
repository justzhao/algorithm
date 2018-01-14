package com.zhaopeng.list;

import com.zhaopeng.bean.ListNode;

/** https://leetcode.com/problems/merge-two-sorted-lists/
 * Created by zhaopeng on 2018/1/7.
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode();
        ListNode p = null;
        ListNode q = null;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p = l1;
                l1 = l1.next;
            } else {
                p = l2;
                l2 = l2.next;
            }
            p.next = null;
            if (head.next == null) {
                head.next = p;
            } else {
                q.next = p;
            }
            q = p;
        }
        if (l1 != null) {
            q.next = l1;
        }
        if (l2 != null) {
            q.next = l2;
        }
        return head.next;
    }


    ListNode merge(ListNode l, ListNode r) {
        if (l == null && r == null) {
            return null;
        }
        if (l == null) {
            return r;
        }
        if (r == null) {
            return l;
        }
        if (l.val < r.val) {
            l.next = merge(l.next, r);
            return l;
        } else {
            r.next = merge(l, r.next);
            return r;
        }
    }
}
