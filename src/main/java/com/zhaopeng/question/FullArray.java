package com.zhaopeng.question;

/**
 * 全排列
 * Created by zhaopeng on 2016/9/6.
 */
public class FullArray {

    public   static  void  main(String args[]){
        /**
         * 递归的思想：
         * 设 输入为 3,4,5则他的全排列有
         *  3 4 5,
         *  4 3 5,
         *  5 4 3,
         *  3 5 4，
         *  5 3 4,
         *  4 5 3,
         *
         *                        考虑  4 3 5和5 4 3的结果
         * 他是 3 4 5 中的3 分别和4 ，5 交换得到的
         *
         * 同时  3 4 5 的后面两个数字 交换得到 3 5 4
         *
         * 然后根据 4 3 5 后面两个数交换得到  4  5 3
         *     根据 5 4 3 后面两个数交换得到  5  3  4 。这一得到共六种数据
         *
         *
         *
         *  所以全排列就是第一个数字开始，每个数字和他后面的数字交换。
         *
         */
        int arr[]={3,4,5};

        range(arr,0,arr.length-1);

    }

    /**
     *
     * @param arr
     * @param l 表示当前遍历到的数字
     * @param h 共多少个数字
     */
    public  static  void range(int arr[],int l, int h){

        if(l==h){
            for(int i=0;i<arr.length;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }else {
            for (int i=l;i<=h;i++){

                swap(arr,i,h);
                range(arr,l+1,h);
                swap(arr,i,h);
            }
        }

    }

    public static   void   swap(int arr[],int a,int b){

             int temp=arr[a];
             arr[a]=arr[b];
             arr[b]=temp;

    }
}
