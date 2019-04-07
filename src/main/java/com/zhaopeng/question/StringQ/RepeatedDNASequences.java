package com.zhaopeng.question.StringQ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/repeated-dna-sequences/description/
 * 一个只包含四种字符的字符串，让你找出其所有长度为10的子字符串中出现次数超过1次的子字符串。最后的结果中不能有重复字串
 * Created by zhaopeng on 2018/5/13.
 */
public class RepeatedDNASequences {

    public List<String> findRepeatedDnaSequences(String s) {

        List<String> res=new ArrayList();
        if(s==null||s.length()<10){
            return res;
        }


        Map<String,Integer> map=new HashMap<>();


        for(int i=0;i<=s.length()-10;i++){

            String temp=s.substring(i,i+10);

            if(map.containsKey(temp)){

                if(map.get(temp)==1){
                    res.add(temp);
                    map.put(temp,2);
                }

            }else{

                map.put(temp,1);
            }



        }




        return res;
    }
}
