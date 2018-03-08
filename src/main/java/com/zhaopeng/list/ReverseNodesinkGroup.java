package com.zhaopeng.list;

import com.zhaopeng.bean.ListNode;

/**
 * Created by zhaopeng on 2018/2/14.
 */
public class ReverseNodesinkGroup {

    public static void main(String args[]) {

        ReverseNodesinkGroup o = new ReverseNodesinkGroup();

        ListNode node = new ListNode(1);

        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        int k = 2;
        //int k=1;
        System.out.println(o.reverseKGroup(node, k));
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode node = head;
        int count = 0;
        while (node != null && count != k) {
            node = node.next;
            count++;
        }
        if (count != k) {
            return head;
        }
        //已经是k+1个节点。逆转后面的，
        node = reverseKGroup(node, k);
        //接下来是逆转当前的,后插法
        while (count-- > 0) {
            //保存下一个节点
            ListNode tmp = head.next;
            head.next = node;
            //保存后继节点。
            node = head;
            //更新头节点
            head = tmp;
        }
        head = node;
        return head;
    }

    public ListNode reverseKGroup(ListNode head, int k, int count) {
        if (count == 0) {
            return reverseKGroup(head, k);
        }
        ListNode next = head.next;
        ListNode newHead = reverseKGroup(head.next, k, count--);
        next.next = head;
        head.next = null;
        return newHead;
    }
}
