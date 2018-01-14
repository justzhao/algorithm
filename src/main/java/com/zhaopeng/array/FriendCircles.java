package com.zhaopeng.array;

/**
 * https://leetcode.com/problems/friend-circles/description/
 * Created by zhaopeng on 2018/1/10.
 */
public class FriendCircles {

    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) {
            return 0;
        }
        int n = M.length;
        boolean visited[] = new boolean[n];
        int count = 0;
        // 其实就是图遍历，已经遍历的就不要在遍历了
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                find(i, visited, M);
                count++;
            }
        }
        return count;
    }

    public void find(int index, boolean[] visited, int[][] s) {
        for (int i = 0; i < s.length; i++) {
            if (s[index][i] == 1 && !visited[i]) {
                visited[i] = true;
                find(i, visited, s);
            }
        }
    }

}
