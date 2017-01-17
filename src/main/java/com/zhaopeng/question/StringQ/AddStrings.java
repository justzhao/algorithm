package com.zhaopeng.question.StringQ;

/**
 * Created by zhaopeng on 2017/1/17.
 */
public class AddStrings {

    public String addStrings(String num1, String num2) {
        if (num1==null||num2==null) return null;

        String max;
        String min;
        if(num1.length()>num2.length()){
            max=num1;
            min=num2;
        }else {
            max=num2;
            min=num1;
        }
        StringBuffer sb=new StringBuffer();

        int next=0;
        int j=max.length()-1;
        for(int i=min.length()-1;i>=0;i--){
            int a=min.charAt(i)-'0';
            int b=max.charAt(j)-'0';
            j--;
            int sum=a+b+next;
            next=sum/10;
            int res=sum%10;
            sb.insert(0,res);
        }

        for (int i=max.length()-min.length()-1;i>=0;i--){
            int a=max.charAt(i)-'0';
            int sum=a+next;
            next=sum/10;
            int res=sum%10;
            sb.insert(0,res);
        }
        if(next>0) sb.insert(0,next);
        return sb.toString();
    }

    public static  void main(String args[]){
        String a="123";
        String b="934";
        AddStrings r=new AddStrings();
        System.out.println(r.addStrings(a,b));
        int c=a.charAt(1);
        System.out.println(c);
    }

}
