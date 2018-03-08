package com.zhaopeng.list;

import com.zhaopeng.bean.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list/description/
 * Created by zhaopeng on 2018/2/8.
 */
public class ReverseLinkedList {

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

    //尾插
    public ListNode reverseList2(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode tmp=null;
        ListNode p=head;
        while(head!=null){
            p=head;
            head=head.next;
            p.next=tmp;
            tmp=p;
        }
        return p;
    }
    //头插
    public ListNode reverseList1(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode(1);
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            if (newHead.next == null) {
                newHead.next = cur;
                cur.next = null;
            } else {
                cur.next=newHead.next;
                newHead.next=cur;
            }
            cur = next;
        }
        return newHead.next;
    }
}
