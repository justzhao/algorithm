package com.zhaopeng.question.BinaryTreeQ;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同
 * Created by zhaopeng on 2017/12/24.
 */
public class VerifySquenceOfBSTQ {

    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null||sequence.length==0) {
            return false;
        }
        return isSequenceOfBST(sequence, 0, sequence.length - 1);
    }

    public boolean isSequenceOfBST(int[] seq, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (start == end - 1) {
            return true;
        }
        int root = seq[end];
        int index = end;

        //寻找下个子树的根节点，
        for (int i = start; i <= end - 1; i++) {
            if (seq[i] > root) {
                index = i;
                break;
            }
        }
        for (int i = index; i <= end - 1; i++) {
            if (seq[i] < root) {
                return false;
            }
        }
        return isSequenceOfBST(seq, start, index - 1) && isSequenceOfBST(seq, index, end - 1);
    }

    public static void main(String args[]) {
        int nums[] = {1, 2,3,4, 5};

        VerifySquenceOfBSTQ o = new VerifySquenceOfBSTQ();
        System.out.println(o.VerifySquenceOfBST(nums));
    }

}
