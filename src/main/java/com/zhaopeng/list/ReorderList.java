package com.zhaopeng.list;

import com.zhaopeng.bean.ListNode;

/**
 * Created by zhaopeng on 2018/2/8.
 */
public class ReorderList {
    public void reorderList1(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = slow;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = null;
        slow = reverseList(slow);
        merge(head, slow, 1);
    }
    public ListNode merge(ListNode n1, ListNode n2, int index) {

        if (n1 == null) {
            return n2;
        }
        if (n2 == null) {
            return n1;
        }
        if (index % 2 != 0) {
            n1.next = merge(n1.next, n2, index + 1);
            return n1;
        } else {
            n2.next = merge(n1, n2.next, index + 1);
            return n2;
        }

    }
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        //这里是先记录 下一个节点，待会需要它指向head节点
        ListNode nextNode = head.next;
        //获取最新的头节点
        ListNode newHead = reverseList(nextNode);
        //逆转
        nextNode.next = head;
        head.next = null;
        return newHead;
    }









    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode prev = null, slow = head, fast = head, l1 = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        ListNode l2 = reverse(slow);


        merge(l1, l2);
    }

    ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head, next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    void merge(ListNode l1, ListNode l2) {
        while (l1 != null) {
            ListNode n1 = l1.next, n2 = l2.next;
            l1.next = l2;

            if (n1 == null)
                break;

            l2.next = n1;
            l1 = n1;
            l2 = n2;
        }
    }
}
