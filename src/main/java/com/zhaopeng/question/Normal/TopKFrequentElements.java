package com.zhaopeng.question.Normal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zhaopeng on 2017/6/8.
 */
public class TopKFrequentElements {


    public List<Integer> topKFrequent(int[] nums, int k) {


        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {

            if (map.get(i) == null) {
                map.put(i, 1);
            } else {
                int count = map.get(i);
                count++;
                map.put(i, count);
            }
        }

        List<Integer>[] frequents = new ArrayList[nums.length + 1];
        for (int key : map.keySet()) {

            int counts = map.get(key);

            if (frequents[counts] == null) {
                frequents[counts] = new ArrayList<>();
            }
            frequents[counts].add(key);
        }
        List<Integer> result = new ArrayList<>();

        int count=0;

        for (int i = frequents.length-1; i>0; i--) {
            if (frequents[i] != null) {
                result.addAll(frequents[i]);

                if(result.size()==k){
                    break;
                }

            }
        }

        return result;

    }
}
