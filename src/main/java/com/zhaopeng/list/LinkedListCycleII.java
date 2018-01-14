package com.zhaopeng.list;

import com.zhaopeng.bean.ListNode;

/**
 * Created by zhaopeng on 2018/1/4.
 */
public class LinkedListCycleII {

    /**
     *   假设 链表开始节点为o,相遇节点为 p, 存在环节点x,环的大小为size
     *
     *   则当s和f节点相遇的时候
     *   d(s)=ox+xp;
     *   d(f)=ox+size+xp;
     *   因为每次f比s都快一步，所以有2d(s)=d(f)
     *
     *   2（ox+xp）=ox+xp+size推导出 ox+xp=size;
     *
     *   即 有ox=size-xp;
     *   所以当s和f相遇之后，如果此时有另外的记得 q从o出发，一次走一步，当和s相遇的节点就是我们需要的节点
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {


        if (head == null) {
            return null;
        }
        ListNode p = head;
        ListNode q = head;
        while (p != null) {
            p = p.next;
            q = q.next;
            if (p == null || q == null) {
                return null;
            }
            p = p.next;
            if (p == q) {
                ListNode o=head;
                while(o!=q){
                    o=o.next;
                    q=q.next;
                }
                return o;

            }
        }
        return null;

    }
}
