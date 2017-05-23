package com.zhaopeng.question.Normal;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaopeng on 2017/5/23.
 */
public class CopyListwithRandomPointer {

    public RandomListNode copyRandomList(RandomListNode head) {

        if (head == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode p = head;
        while (p != null) {
            map.put(p, copy(p));
            p = p.next;
        }
        p = head;
        while (p != null) {
            RandomListNode q = map.get(p);
            q.next = map.get(p.next);
            q.random = map.get(p.random);
            p = p.next;
        }
        return map.get(head);
    }

    public RandomListNode copy(RandomListNode node) {

        if (node == null) {
            return null;
        }
        RandomListNode n = new RandomListNode(node.label);
        return n;
    }

}

class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
}