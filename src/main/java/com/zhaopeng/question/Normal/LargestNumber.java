package com.zhaopeng.question.Normal;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by zhaopeng on 2017/5/26.
 */
public class LargestNumber {

    public String largestNumber(int[] nums) {

        if (nums == null || nums.length == 0) {
            return "";
        }
        String result[] = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(result, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s2.compareTo(s1);
            }
        });
        if (result[0].charAt(0) == '0') return "0";
        StringBuilder sb = new StringBuilder();
        for (String s : result) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String args[]){

        LargestNumber s=new LargestNumber();
        int nums[]=new int[2];
        nums[0]=1;
        nums[1]=2;
        System.out.println(s.largestNumber(nums));
    }
}
