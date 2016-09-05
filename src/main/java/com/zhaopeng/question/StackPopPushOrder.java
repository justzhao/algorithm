package com.zhaopeng.question;

import java.util.Stack;

/**
 * 给定两个整数序列，第一个序列是栈的压入序列， 判断第二个整数序列是不是第一个整数序列的出栈序列
 * Created by zhaopeng on 2016/9/5.
 */
public class StackPopPushOrder {

    public static  void main(String args[]){
        /**
         *  思想：维护当前栈。遍历弹出序列，如果当前栈顶元素是下一个要弹出的的元素，则直接弹出栈定元素
         *  如果不是，则继续把未入栈的元素入栈，知道找到对应的出栈元素，如果没找到，则不是弹出序列，否则
         *  是对应的弹出序列。
         */

        int push[]={1,2,3,4,5};
        int pop[]={4,3,5,1,2};

        System.out.println(isPopPushOrder(push,pop));


    }

    /**
     *
     * @param push 压入序列
     * @param pop 弹出序列
     *
     * @return
     */
    public  static  boolean isPopPushOrder(int push[],int pop[]){
        boolean isOrder=false;

        Stack<Integer> stack=new Stack();
        int j=0;//当前入栈元素。
        for(int i=0;i<pop.length;i++){

             isOrder=false;

            int nowPop=pop[i];//当前出栈元素.

            if(stack.empty()||stack.peek()!=nowPop){
                //如果当前栈为空。


                if(j==push.length-1){
                    //已经遍历完了。
                    return  isOrder;
                }
                for(int k=j;k<push.length;k++)
                {
                    j++;
                    if(nowPop==push[k]){
                        //找到了对应的元素
                        isOrder=true;
                        break;
                    }else{
                        //入栈
                        stack.push(push[k]);
                    }

                    //如果遍历完了 push数组还没有找到出栈元素，则可以肯定不是出栈序列
                    if(k==push.length-1&&!isOrder){
                        return  isOrder;
                    }
                }


            }else {
                 //当前栈顶元素就是要弹出的，直接弹出
                    stack.pop();
                    isOrder=true;
            }

        }


        return  isOrder;
    }
}
