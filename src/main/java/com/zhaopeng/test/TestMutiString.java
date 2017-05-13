package com.zhaopeng.test;

import com.google.common.collect.Sets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by zhaopeng on 2017/5/13.
 */
public class TestMutiString {

    public static void main(String args[]) {

        String a = "rwer,124,234,dg,sd,23432,123,1231,3,123,1243,453,45,123,,werwe,rw,3123";

        String [] strs=a.split(",");

        List<String> cr=Arrays.asList(strs);
        HashSet<String> sets = Sets.newHashSet(Arrays.asList(a.split(",")));

        System.out.println(sets+" : "+sets.size());

        System.out.println(sets.contains("123"));
        System.out.println(sets.contains("12"));
    }
}
