package com.zhaopeng.question.StringQ;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/restore-ip-addresses/description/
 * Created by zhaopeng on 2018/2/21.
 */
public class RestoreIPAddresses {

    public static void main(String args[]) {

        RestoreIPAddresses o = new RestoreIPAddresses();

       // String s = "25525511135";
        //String s="0000";
        String s="010010";
        System.out.println(o.restoreIpAddresses(s));
    }

    public List<String> restoreIpAddresses(String s) {

        List<String> res = new ArrayList<>();

        helper(0, 1, s, new ArrayList<Integer>(), res);
        return res;
    }

    public void helper(int start, int index, String s, List<Integer> nums, List<String> res) {
        if (nums.size() == 4) {

            if(s.length()!=start){
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < nums.size(); i++) {
                sb.append(nums.get(i));
                if (i != nums.size() - 1) {
                    sb.append(".");
                }
            }
            res.add(sb.toString());
            return;
        }

        for (int i = index; i <= s.length(); i++) {
            if (start == i) {
                continue;
            }
            String temp = s.substring(start, i);
            if(temp.startsWith("0")&&temp.length()>1){
                continue;
            }
            int v = Integer.valueOf(temp);
            if (v > 255) {
                break;
            }
            if (v >= 0 && v <= 255) {
                nums.add(v);
                helper(i, i + 1, s, nums, res);
                nums.remove(nums.size() - 1);

            }
        }
    }
}
