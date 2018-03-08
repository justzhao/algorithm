package com.zhaopeng.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/triangle/description/
 * Created by zhaopeng on 2018/2/3.
 * <p>
 * <p>
 * f(x,y) 表示第x层，y点
 * f(x,y)= Math.min(f(x-1,y),f(x-1,y+1))+triangle(x,y);
 */
public class Triangle {

    public static void main(String args[]) {
        Triangle o = new Triangle();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(-1));
        triangle.add(Arrays.asList(-2, -3));
        System.out.println(o.minimumTotal(triangle));

    }

    /**
     * 应该是从底部向上算，为啥，
     * 如果从顶部向下算，需要保存多个数据。
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {

        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }

        int h = triangle.size();
        // 记录每一层的需要的步数
        int res[] = new int[h+1];

        for (int i = h - 1; i >= 0; i--) {
            List<Integer> steps = triangle.get(i);
            for (int j = 0; j < steps.size(); j++) {
                //f(x,y)= Math.min(f(x-1,y),f(x-1,y+1))+triangle(x,y);

                res[j] = Math.min(res[j], res[j + 1]) + steps.get(j);


            }
        }
        return res[0];
    }
}
