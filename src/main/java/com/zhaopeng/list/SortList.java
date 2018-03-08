package com.zhaopeng.list;

import com.zhaopeng.bean.ListNode;

/**
 * https://leetcode.com/problems/sort-list/description/
 * Created by zhaopeng on 2018/1/7.
 */
public class SortList {

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {

            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //分成两个列表做归并排序
        prev.next = null;

        ListNode l = sortList(head);
        ListNode r = sortList(slow);
        return merge(l, r);

    }

    /**
     * 合并两个有序列表
     *
     * @param l
     * @param r
     * @return
     */
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
