package com.zhaopeng.digital;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/gray-code/description/
 * Created by zhaopeng on 2018/2/21.
 */
public class GrayCode {


    /**
     * G（i）=i ^ (i/2)
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            result.add(i ^ i >> 1);
        }
        return result;
    }
}
