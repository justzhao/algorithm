package com.zhaopeng.question;

import com.zhaopeng.bean.ListNode;
import com.zhaopeng.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/** 给定一个升序列表，建立一个高度平衡的二叉搜索树
 * Created by zhaopeng on 2016/12/6.
 *
 * http://blog.csdn.net/realxuejin/article/details/12872035
 * http://www.cnblogs.com/duyy/p/3671176.html
 *
 * 删除二叉树的节点
 * 如果要删除的节点为叶子节点，就找到了要删除的节点
 * 如果要删除的节点为只有一棵子树的节点就找到了要删除的节点
 * 如果要删除的节点既有左子树，又有右子树，则
 * 如果该节点的平衡因子为0或者1，则找到其左子树中具有最大值的节点max
 * （我们只讨论有序平衡二叉树，并且有序平衡二叉树中任意一个节点的左子树上的所有节点的值小于该节点的值，
 * 右子树上所有节点的值大于该节点的值），将max的内容与x的内容交换（只替换保存的真正的数据，不替换指针，平衡因子等用于管理目的的信息），
 * 并且max即为新的要删除的节点。由于树是有序的，因而这样找到的节点要么是一个叶子节点，要么是一个没有右子树的节点。
 * 如果该节点的平衡因子为-1，则找到其右节点中具有最小值的节点min，将min的内容与x的内容交换，并且min即为新的要删除的节点。
 * 由于树是有序的，因而这样找到的节点要么是一个叶子节点，要么是一个没有左子树的节点。
 */
public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {

        List<Integer> arrays=new ArrayList<>();
        while (head!=null){
           arrays.add(head.val);
            head=head.next;
        }

        return  buildTree(arrays,0,arrays.size()-1);
    }

    public TreeNode buildTree(List<Integer> arrays,int start,int end){
        if(start>end) return null;

        int mid=(start+end)/2;
        TreeNode root=new TreeNode(arrays.get(mid));
        root.left=buildTree(arrays,start,mid-1);
        root.right=buildTree(arrays,mid+1,end);

        return  root;

    }
    /**
     *     static ListNode currentHead = null;
     TreeNode buildTree(int start, int end) {
     if(start>end) {
     return null;
     }
     int mid = start + (end - start)/2;
     TreeNode left = buildTree(start, mid-1);
     TreeNode root = new TreeNode(currentHead.val);
     root.left = left;
     currentHead = currentHead.next;
     root.right = buildTree(mid + 1, end);
     return root;
     }

     public TreeNode sortedListToBST(ListNode head) {
     if(head==null) {
     return null;
     }
     currentHead = head;
     int len = 0;
     while(head!=null) {
     len++;
     head = head.next;
     }

     return buildTree(0, len-1);
     }
     */

}

