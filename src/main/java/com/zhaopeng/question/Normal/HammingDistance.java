package com.zhaopeng.question.Normal;

/**
 * Created by zhaopeng on 2017/3/8.
 */
public class HammingDistance {

    public int hammingDistance(int x, int y) {

        int res=x^y;
        int count=0;
        while (res>0){
            res=res&(res-1);
            count++;
        }
        return  count;
    }
    public static  void main(String args[]){
        HammingDistance v=new HammingDistance();
        System.out.println(v.hammingDistance(1,4));
    }
}
