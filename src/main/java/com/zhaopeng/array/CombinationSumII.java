package com.zhaopeng.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-ii/description/
 * Created by zhaopeng on 2017/12/23.
 * <p>
 * 此题的关键是如何去重复
 */
public class CombinationSumII {

    public static void main(String args[]) {

        CombinationSumII o = new CombinationSumII();
        int nums[] = {10, 1, 2, 7, 6, 1, 5};
        int t = 8;
        System.out.println(o.combinationSum2(nums, t));
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);

        comb(res,candidates,target,new ArrayList<Integer>(),0);

        return res;
    }
    public void comb(List<List<Integer>> res,int cadidates[],int taget,List<Integer> temp,int index){
        if(taget<0){
            return;
        }
        if(taget==0){
            res.add(new ArrayList(temp));
        }
        //如何去重
        for (int i=index;i<cadidates.length;i++){
            temp.add(cadidates[i]);
            comb(res,cadidates,taget-cadidates[i],temp,i+1);//同一个数字不需要选2次，直接选下一个
            temp.remove(temp.size()-1);
            //数组中出现同样的数字需要跳过，否则会出现同样的组合。
            while (i<cadidates.length-1&&cadidates[i]==cadidates[i+1]){
                i++;
            }
        }
    }
}
