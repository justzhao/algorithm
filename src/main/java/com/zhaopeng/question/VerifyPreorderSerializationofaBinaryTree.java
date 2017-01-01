package com.zhaopeng.question;

/**
 * 给定一个字符串，验证是否为一个二叉树的前序遍历，空节点使用#
 * "9,  3,4,#,#,1,#,  #,2,#,6,#,#"  13个
 * Created by zhaopeng on 2017/1/1.
 */
public class VerifyPreorderSerializationofaBinaryTree {
    /**
     * 思想：
     * 注意 空节点的个数总是比非空节点的个数多一个
     * 添加一个数字节点的时候 空节点比原来多一个，但是初始化情况下，一个非空根节点有两个空节点
     */
    public boolean isValidSerialization(String preorder) {

        /**
         * 9,  3,4,#,#,1,#,#,   2,#,6,#,#"
         */

        String nodes[]=preorder.split(",");
        if(nodes.length%2==0) return false;
        if(nodes.length>1&&nodes[0].equals("#")){
            return false;
        }
        if(nodes.length==1&&nodes[0].equals("#")){
            return true;
        }
        int count=2;
        for(int i=1;i<nodes.length;i++){
            if(nodes[i].equals("#")){
                count--;
                if(count==0&&i!=(nodes.length-1)) return false;
                if(count<0) return false;
            }else {
                count++;
            }
        }
        return count==0;

    }


    public static void main(String args[]){
    //        String str="9,3,4,#,#,1,#,#,2,#,6,#,#";
      //  String str="#,#,#";
        String str="7,2,#,2,#,#,#,6,#";
        VerifyPreorderSerializationofaBinaryTree v=new VerifyPreorderSerializationofaBinaryTree();

        System.out.println(v.isValidSerialization(str));
    }
}
