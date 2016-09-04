package com.zhaopeng.question;

/**
 * 求一个整数的二进制中1 的个数。
 *
 * Created by zhaopeng on 2016/9/4.
 */
public class NumberOfOne {
    public  static  void  main(String []args){
        /**
         * 思路：
         * 利用位运算中的与运算(&)  1 和0 与运算得到 0；
         *
         * 整数 n 减1 之后，n 的二进制 右边数 的第一个1 会变为0，而第一个1 的右边
         * 的0 会全部变1 。这一和原来的整数n左与运算，就可以消去 一个1。
         *
         * 负数也适用。
         * 注意-1 的二进制是补码表示 11111111
         *
         */
        int num=10;
       System.out.println(countNumberOne(num));

    }


    public  static int  countNumberOne(int num){

        int count=0;
        while (num>0){
            num=num&(num-1);
            count++;
        }
        return  count;
    }
}
