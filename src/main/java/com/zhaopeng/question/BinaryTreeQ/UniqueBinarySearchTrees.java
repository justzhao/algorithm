package com.zhaopeng.question.BinaryTreeQ;

/**
 * 输入一组节点的个数，求一共有多少种唯一二叉搜索树
 * Created by zhaopeng on 2016/11/24.
 */
public class UniqueBinarySearchTrees {
    /**
     * 思路：
     *  输入n个节点，可以选取n 种方式作为根节点。
     *
     *  当选取一个节点作为根节点时候，设左边有k个节点，则右边有n-k-1 个节点。
     *  值得注意的是 这里是二叉搜索树，当确立一个点位根节点的时候，左右的节点个数是确定的
     *  而左子树的个数乘以右子树的个数为当前节点的个数。
     *
     *  这样转化成求k个节点一共有多少个二叉搜索树，n-k-1个节点一共有多少个二叉搜索树。
     *  在这里可以用递归也可以用动态规划
     *  当 n=0时候 sum=0;
     *    n=1时候，sum=1；
     *    n=2时候，sum=2
     *    n=3时候 sum=5
     *
     *
     */

    public int numTrees(int n) {
        if(n<=0)
            return 0;
        if(n==1)return 1;
        if(n==2)return 2;

        int sum[]=new int[n+1];
        sum[0]=1;//当某个子树的个数为0时候，个数由另外一边子树个数决定。
        sum[1]=1;
        sum[2]=2;
        for(int i=3;i<=n;i++){
            int temp=0;
            // 轮流每个节点作为根节点
            // 第一个节点做根节点的时候，左子树为空
            // 最后节点做根节点的时候，右子树为空
            for(int j=0;j<i;j++){
                // 考虑 左子树或者右子树为空的情况，
                // 因为根需要占用一个节点所以是i-j-1
                temp+=sum[j]*sum[i-j-1];
            }
            sum[i]=temp;
        }

        return sum[n];
    }

    public static void main(String args[]){
        UniqueBinarySearchTrees uniqueBinarySearchTrees=new UniqueBinarySearchTrees();

        System.out.println(uniqueBinarySearchTrees.numTrees(4));
    }
}
