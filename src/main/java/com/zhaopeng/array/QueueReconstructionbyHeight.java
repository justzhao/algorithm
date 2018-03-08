package com.zhaopeng.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/queue-reconstruction-by-height/description/
 * Created by zhaopeng on 2018/1/13.
 */
public class QueueReconstructionbyHeight {
    /**
     * Input:
     * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
     * <p>
     * Output:
     * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
     * <p>
     * <p>
     * <p>
     * <p>
     * Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
     * List<int[]> list = new LinkedList<>();
     * for (int[] p : people) {
     * list.add(p[1], p);
     * }
     * return list.toArray(new int[list.size()][]);
     */
//https://leetcode.com/problems/queue-reconstruction-by-height/discuss/89350
    public int[][] reconstructQueue(int[][] people) {


        if (people == null || people.length == 0 || people[0].length == 0)
            return new int[0][0];

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                // 首先按升高从大到小排序，如果身高相等，则按照 人数升序，为什么不懂？
                // 为什么身高从大到小排序。
                return a[0] == b[0] ? a[1] - b[1] : b[0] - a[0];
            }
        });

        int n = people.length;
        ArrayList<int[]> tmp = new ArrayList<>();
        // 0表示身高 1 表示 前面的人。
        for (int i = 0; i < n; i++) {
            //index -》 value
            tmp.add(people[i][1], new int[]{people[i][0], people[i][1]});
        }
        int[][] res = new int[people.length][2];
        int i = 0;
        for (int[] k : tmp) {
            res[i][0] = k[0];
            res[i++][1] = k[1];
        }

        return res;
    }
}
