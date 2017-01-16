package com.zhaopeng.question.BinaryTreeQ;

/**
 * 两个二进制字符串数字相加
 * Created by zhaopeng on 2016/11/19.
 */
public class AddBinaryString {

    public String addBinary(String a, String b) {

        if(a==null&&b==null){
            return "";
        }
        if(a==null||"".equals(a)){
            return b;
        }
        if(b==null||"".equals(b)){
            return  a;
        }

        StringBuffer sum=new StringBuffer();

        int lena=a.length();
        int lenb=b.length();

        String maxstr="";
        String minstr="";
        int max=0;
        int min=0;
        if(lena>lenb){
            maxstr=a;
            max=lena;
            minstr=b;
            min=lenb;
        }else {
            maxstr=b;
            max=lenb;
            minstr=a;
            min=lena;
        }
        int flag=0;
        //短的字符串补充0
        for (int i=0;i<max-min;i++){
            minstr="0"+minstr;
        }

        String res="";
        for(int i=max-1;i>=0;i--){
            char add1=minstr.charAt(i);
            char add2=maxstr.charAt(i);
            int sum1=add1-'0'+add2-'0'+flag;
            if(sum1>1){
                sum1=sum1%2;
                flag=1;
            }else {
                flag=0;
            }
            res=sum1+res;
        }

        if(flag==1){
            res="1"+res;
        }


        return  res;
    }


    public  static  void main(String args[]){

        String a="0";
        String b="1";
        AddBinaryString addBinaryString=new AddBinaryString();
        System.out.println(addBinaryString.addBinary(a,b));

    }
}
