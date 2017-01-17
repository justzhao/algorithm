package com.zhaopeng.question.StringQ;

/**
 * Created by zhaopeng on 2017/1/17.
 */
public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String str) {
        if(str==null) return false;
        if(str.equals(""))return  true;


        for (int i=0;i<str.length()/2;i++){

            String c=str.substring(0,i+1);

            if(str.length()%c.length()!=0) continue;

            int size=str.length()/c.length();

            StringBuffer res=new StringBuffer();
            while (size>0){
                res.append(c);
                size--;
            }

            if(res.toString().equals(str)) return true;

        }

        return false;
    }

    public  static void main(String args[]){
        String c="aaaaaaaaaaaaaaaaaaaaa";
        RepeatedSubstringPattern r=new RepeatedSubstringPattern();
        System.out.println(c.length()+"   " +c.substring(0,1));

        System.out.println(r.repeatedSubstringPattern(c));
    }
}
