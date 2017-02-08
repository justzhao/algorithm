package com.zhaopeng.question.StringQ;

import java.util.ArrayList;
import java.util.List;

/**
 * 输出字符串所有的组合
 * Created by zhaopeng on 2017/2/7.
 */
public class AllcombinationOfStr {

    public int findSubstringInWraproundString(String p) {

        if (p == null || p.equals("")) return 0;

        List<String> result = new ArrayList<>();

        char[] chars = p.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int len = 1; len <= p.length(); len++) {
            comb(result, chars, 0, len, sb);
        }

        System.out.println(result.toString());
        return result.size();
    }

    public void comb(List<String> result, char[] chars, int index, int num, StringBuilder sb) {
        if (num == 0) {
            if (!result.contains(sb.toString())) result.add(sb.toString());
        }
        if(index==(chars.length)) return;
        //选第一个
        sb.append(chars[index]);
        comb(result,chars,index+1,num-1,sb);
        sb.deleteCharAt(sb.length()-1);
        comb(result,chars,index+1,num,sb);
    }

    public static void main(String args[]){
        String s="zab";
        AllcombinationOfStr v=new AllcombinationOfStr();
        System.out.println(v.findSubstringInWraproundString(s));
    }
}
