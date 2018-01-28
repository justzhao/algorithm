package com.zhaopeng.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaopeng on 2018/1/26.
 */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {

        List<String> res=new ArrayList<>();
        for (int i = 1; i <= n; i++) {

            if(i%3==0&&i%5==0){
                res.add("FizzBuzz");
            }else if(i%3==0){
                res.add("Fizz");
            }else if(i%5==0){
                res.add("Buzz");
            }
        }

        return res;

    }
}
