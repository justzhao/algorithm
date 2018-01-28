package com.zhaopeng.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/course-schedule-ii/description/
 * Created by zhaopeng on 2018/1/22.
 */
public class CourseScheduleII {
    public static void main(String args[]) {
        //nt a[][] = {{1,0},{2,0},{3,1},{3,2}};

        int a[][] = {{1, 0}};
        int n = 2;
        CourseScheduleII o = new CourseScheduleII();

        System.out.println(o.findOrderBFS(n, a));
    }

    public int[] findOrderBFS(int numCourses, int[][] prerequisites) {
        //入度
        int[] degree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            degree[prerequisites[i][0]]++;
        }
        int[] ret = new int[numCourses];
        int k = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
                ret[k++] = i;
            }
        }
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == pre) {
                    degree[prerequisites[i][0]]--;
                    if (degree[prerequisites[i][0]] == 0) {
                        queue.offer(prerequisites[i][0]);
                        ret[k++]=prerequisites[i][0];
                    }
                }
            }
        }
        if(k!=numCourses){
            return  new int[0];
        }
        return ret;
    }

    //使用临接表来表示图
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; ++i)
            graph.add(new ArrayList<Integer>());

        for (int i = 0; i < prerequisites.length; ++i) {
            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];
            graph.get(course).add(prerequisite);
        }

        int[] visited = new int[numCourses];
        List<Integer> ans = new ArrayList<Integer>();

        for (int i = 0; i < numCourses; ++i)
            if (!dfs(i, graph, visited, ans)) return new int[0];

        return listToArray(ans);
    }

    private boolean dfs(int curr, ArrayList<ArrayList<Integer>> graph, int[] visited, List<Integer> ans) {
        if (visited[curr] == 1) return false;
        if (visited[curr] == 2) return true;
        visited[curr] = 1;

        //  保存前驱,因为访问 a 必须访问b
        for (int next : graph.get(curr))
            if (!dfs(next, graph, visited, ans)) return false;

        ans.add(curr);
        visited[curr] = 2;
        return true;
    }

    private int[] listToArray(List<Integer> l) {
        int res[] = new int[l.size()];
        int k = 0;
        for (int n : l) {

            res[k++] = n;
        }
        return res;

    }


    /**
     public int[] findOrder(int numCourses, int[][] prerequisites) {
     ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

     for (int i = 0; i < numCourses; ++i)
     graph.add(new ArrayList<Integer>());

     for (int i = 0; i < prerequisites.length; ++i) {
     int course = prerequisites[i][0];
     int prerequisite = prerequisites[i][1];
     graph.get(course).add(prerequisite);
     }

     int[] visited = new int[numCourses];
     List<Integer> ans = new ArrayList<Integer>();

     for (int i = 0; i < numCourses; ++i)
     if (!dfs(i, graph, visited, ans)) return new int[0];

     return listToArray(ans);
     }

     private boolean dfs(int curr, ArrayList<ArrayList<Integer>> graph, int[] visited, List<Integer> ans) {
     if (visited[curr] == 1) return false;
     if (visited[curr] == 2) return true;

     visited[curr] = 1;
     for (int next : graph.get(curr))
     if (!dfs(next, graph, visited, ans)) return false;

     visited[curr] = 2;
     ans.add(curr);

     return true;
     }
     */
}
