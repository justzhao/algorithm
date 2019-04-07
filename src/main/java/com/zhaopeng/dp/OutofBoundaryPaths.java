package com.zhaopeng.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 图类型题目都是DFS
 * Created by zhaopeng on 2018/5/27.
 */
public class OutofBoundaryPaths {

    /**
     * 四个顶点的作用,表示四个方向的移动
     *
     */
    int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};



    public int findPaths(int m, int n, int N, int i, int j) {
        return dfs(m, n, N, i, j);
    }

    public int dfs(int m, int n, int N, int i, int j) {
        /**
         * 边界条件
         */
        if (i < 0 || i >= m || j < 0 || j >= n) return 1;

        /**
         * 步数用完了，走不到边界
         */
        if (N == 0) return 0;

        String string = Arrays.toString(new int[] {i, j, N});
        if (map.containsKey(string)) {
            return map.get(string);
        }

        int res = 0;
        for (int[] dir : dirs) {
            res = (res + dfs(m, n, N - 1, i + dir[0], j + dir[1])) % 1000000007;
        }
        map.put(string, res);
        return res;
    }









    private int [][]directions=new int [][]{{0,1},{0,-1},{1,0},{-1,0}};

    private Map<String,Integer> map=new HashMap();

    public int findPaths1(int m, int n, int N, int i, int j) {

        if(i<0||j<0||i>=m||j>=n){

            return 1;
        }

        if(N==0){
            return 0;
        }

        //String key=i+"-"+j+"-"+N;

        String key=Arrays.toString(new int[] {i, j, N});
        if(map.containsKey(key)){
            return map.get(key);
        }


        int res=0;
        for(int []direction : directions ){

            res=(res+ findPaths1(m,m,N-1,i+direction[0],j+direction[1]))%(1000000007);

        }

        map.put(key,res);

        return res;


    }
}
