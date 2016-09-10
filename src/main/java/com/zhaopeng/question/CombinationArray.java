package com.zhaopeng.question;

import java.util.ArrayList;
import java.util.List;

/**
 *  求一个字符串所有的组合
 *  思想：
 *  递归，对于一个长度为n的字符串，假设选取m个字符的组合，C(m,n)
 *  这时候 对于字符串的第一个字符，有两种情况，
 *   1 选中 ,这时候只需从余下的n-1个字符中选取m-1 。C(m-1,n-1)
 *   2 没选中,这时候需要从余下的n-1个字符串中选取m个。C(m,n-1)
 *   由此产生了递归关系
 *
 * Created by zhaopeng on 2016/9/10.
 */
public class CombinationArray {

    public  static  void  main(String args[]){

        String str="abc";
        combination(str);

    }
    public  static void  combination(String str){
        for (int i=2;i<=str.length();i++){
            //递归
            List<String> result=new ArrayList<String>();
            combina(str,i,result); // 首先求1 个的组合，在求2个的组合，求i个的组合
        }

    }


    public  static void  combina(String str, int m, List<String> result){

        /**
         *
         */
        if(m==0){ // 当需要的字符个数为0的时候，就可以输出当前的结果
            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i));
            }
            System.out.println();
            return;
        }
        if(str.length()!=0){
            result.add(str.charAt(0)+"");//如果当前字符被选中
            combina(str.substring(1,str.length()),m-1,result);
            result.remove(result.size()-1);//当前字符没有被选中
            combina(str.substring(1,str.length()),m,result);

        }



    }
}
