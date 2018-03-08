package com.zhaopeng.list;

import com.zhaopeng.bean.ListNode;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 * Created by zhaopeng on 2018/2/14.
 */
public class MergekSortedLists {


    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        return mergeKLists(lists, 0, lists.length - 1);
    }

    public ListNode mergeKLists(ListNode[] lists, int s, int e) {
        if (s == e) {
            return lists[s];
        }
        int mid = s + (e - s) / 2;

        ListNode left = mergeKLists(lists, s, mid);
        ListNode right = mergeKLists(lists, mid + 1, e);
        return merge(left, right);
    }

    public ListNode merge(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        if (left.val < right.val) {
             left.next = merge(left.next, right);
            return left;
        } else {
             right.next = merge(left, right.next);
            return right;
        }
    }
}
