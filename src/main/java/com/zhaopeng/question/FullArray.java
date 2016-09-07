package com.zhaopeng.question;

/**
 * 全排列
 * Created by zhaopeng on 2016/9/6.
 */
public class FullArray {

    public   static  void  main(String args[]){
        /**
         * 参考：
         * http://blog.csdn.net/wuzhekai1985/article/details/6643127
         * http://7x00ae.com1.z0.glb.clouddn.com/16-9-7/5007085.jpg
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
         *
         *
         *  去重排列：
         *
         *  考虑  3 4 4  首先 第一个数分别和第 二 三 个数交换得到 4 3 4 和4  4  3
         *
         *  然后 由  第二个和第三个 数字相等，所以不交换。
         *  考虑 4 3 4  此时 第二个和 第三个 交换得到 4  4 3  所以就有了重复。
         *                   第一个和第二个 交换得到 3 4  4 有了重复
         *  考虑 在交换l  和 h时候
         *  如果发现[l,h) 中有arr[h] 重复的数字 就不交换。
         *   所以上述情况中：
         *
         *   3  4  4 的  第一个和第二个可以交换  第二个数和第三个数不交换 得到 4 3 4
         *
         *   4 3 4 的 第二个和第三个交换 得到 4  4  3
         *
         *
         * 去重的全排列就是从第一个数字起每个数分别与它后面非重复出现的数字交换
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
            for (int i=l;i<=h;i++){  //第l个数分别与它后面的数字交换就能得到新的排列
               if(isSwap(arr,l,i)) {  // l 和i 之间有没有重复的i

                    swap(arr, i, l);
                    range(arr, l + 1, h);
                    swap(arr, i, l);

                }
            }
        }

    }

    public static   void   swap(int arr[],int a,int b){




            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;


    }

    public  static boolean isSwap(int arr[],int a,int b){

        for(int i=a;i<b;i++){
            if(arr[i]==arr[b])
                return  false;

        }
        return  true;
    }
}
