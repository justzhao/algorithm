package com.zhaopeng.question.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 平分糖果
 * Created by zhaopeng on 2017/5/17.
 */
public class DistributeCandies {

    public int distributeCandies(int[] candies) {


        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < candies.length; i++) {
            Integer count = map.get(candies[i]);
            if (map.values().size() == candies.length / 2) {

                break;

            } else if (count == null) {
                map.put(candies[i], 1);
            }
        }


        return map.values().size();

    }

    public static void main(String args[]) {

        int ca[] =new int[4];
        ca[0]=1;
        ca[1]=1;
        ca[2]=2;
        ca[3]=3;
      /*  ca[4]=3;
        ca[5]=4;*/

      //[1,1,1,1,2,2,2,3,3,3]

        DistributeCandies m=new DistributeCandies();

        System.out.println(m.distributeCandies(ca));

    }
}
