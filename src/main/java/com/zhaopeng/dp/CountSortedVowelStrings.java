package com.zhaopeng.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaopeng on 2021/1/9 12:51 下午.
 */
public class CountSortedVowelStrings {

    public static void main(String args[]){

        CountSortedVowelStrings aa=new CountSortedVowelStrings();

        System.out.println(aa.countVowelStrings(1));
    }


    String []str={"a","e","i","o","u"};
    public int countVowelStrings(int n) {

        List<String> res=new ArrayList();


        helper(res,new StringBuilder(),0,n);
        return res.size();

    }

    private void helper( List<String> res,StringBuilder sb,int index,int n ){

        if(sb.length()==n){


            res.add(sb.toString());
            return;
        }

        for(int i=index;i<str.length;i++){


            sb.append(str[i]);
            helper(res,sb,i+1,n);
            sb.deleteCharAt(sb.length()-1);

        }



    }

}
