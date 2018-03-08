package com.zhaopeng.list;

import com.zhaopeng.bean.ListNode;

/**
 * Created by zhaopeng on 2018/2/8.
 */
public class PartitionList {

    public static void main(String args[]){

        PartitionList o=new PartitionList();
        //[1,1]
        int x=0;
        ListNode head=new ListNode(1);
        head.next=new ListNode(1);
        ListNode h=o.partition(head,x);
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode s = new ListNode(0);
        ListNode b = new ListNode(0);
        ListNode sh = s;
        ListNode sb = b;
        while (head != null) {
            ListNode node = new ListNode(head.val);
            if (head.val < x) {
                sh.next = node;
                sh = sh.next;
            } else {
                sb.next = node;
                sb=sb.next;
            }
            head = head.next;
        }
        sh.next = b.next;
        return s.next;
    }
}
