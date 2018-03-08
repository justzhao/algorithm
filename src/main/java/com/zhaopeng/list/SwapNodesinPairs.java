package com.zhaopeng.list;

import com.zhaopeng.bean.ListNode;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 * Created by zhaopeng on 2018/2/14.
 */
public class SwapNodesinPairs {

    public static void main(String args[]){
        SwapNodesinPairs o=new SwapNodesinPairs();
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        System.out.println(o.swapPairs(head));
    }


    public ListNode swapPairs1(ListNode head) {
        if ((head == null)||(head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs1(head.next.next);
        n.next = head;
        return n;
    }


    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head;
        ListNode res=head.next;
        ListNode next = head;
        ListNode pre = new ListNode();
        pre.next = head;
        while (node != null && node.next != null) {
            next = node.next;
            node.next = next.next;
            next.next = node;
            pre.next = next;

            pre = node;
            node = node.next;
        }

        return res;
    }

}
