package com.zhaopeng.question;

/**
 * 判断一个字符串是不是回文串
 * Created by zhaopeng on 2016/10/1.
 */
public class Palindrome {

    public  static  void  main(String args[]){

        String str="122373221";
        System.out.println(isPalin(str,0,str.length()-1,str.length()));
    }


    public  static  boolean isPalin(String s,int l,int h,int len){

        if(s==null||s.length()==1||len==1||len==0){
            return  true;
        }else{

            char arr[]=s.toCharArray();
            if(arr[l]==arr[h]){

                return  isPalin(s,l+1,h-1,len-2);
            }else {
                return  false;
            }


        }

    }
}
