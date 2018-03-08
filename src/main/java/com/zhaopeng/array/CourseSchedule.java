package com.zhaopeng.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/course-schedule/description/
 * Created by zhaopeng on 2018/1/14.
 * <p>
 * 学1必须学0，0是前置。
 * 2, [[1,0]]
 */
public class CourseSchedule {


    public boolean canFinishBFS(int numCourses, int[][] prerequisites) {

        //入度,以定点i为 目标点的边
        int[] degree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            degree[prerequisites[i][0]]++;
        }
        int res = numCourses;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            // =0表示没有定点以它为终点
            if (degree[i] == 0) {
                queue.offer(i);
                res--;
            }
        }
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == pre) {
                    degree[prerequisites[i][0]]--;
                    if (degree[prerequisites[i][0]] == 0) {
                        queue.offer(prerequisites[i][0]);
                        res--;
                    }
                }
            }
        }
        return res == 0;
    }


    /**
     * huahuajiang
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; ++i)
            graph.add(new ArrayList<Integer>());

        for (int i = 0; i < prerequisites.length; ++i) {
            // 保存前驱,因为访问 a 必须访问b
            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];
            graph.get(course).add(prerequisite);
        }
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; ++i)
            if (!dfs(i, graph, visited)) return false;
        return true;
    }

    private boolean dfs(int curr, ArrayList<ArrayList<Integer>> graph, int[] visited) {
        if (visited[curr] == 1) return false;
        if (visited[curr] == 2) return true;
        visited[curr] = 1;
        for (int next : graph.get(curr))
            if (!dfs(next, graph, visited)) return false;
        visited[curr] = 2;
        return true;
    }


    // 类似图，有没有环，有环就不行。
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList();
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            // 构造图。对于数组中的graph  。节点i，，到一个集合set的  边。
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        for (int i = 0; i < numCourses; i++) {
            // dfs  学习每个课程。
            if (!dfs(graph, visited, i))
                return false;
        }
        return true;
    }

    //如果发现某个节点已经被访问过，证明有环，返回false。
    private boolean dfs(ArrayList[] graph, boolean[] visited, int course) {
        if (visited[course])
            return false;
        else
            visited[course] = true;
        // 遍历graph[course]的所有的边。
        for (int i = 0; i < graph[course].size(); i++) {
            //递归遍历。
            if (!dfs(graph, visited, (int) graph[course].get(i)))
                return false;
        }
        visited[course] = false;
        return true;
    }


   /*8 拓扑排序
   ** 学1必须学0，0是前置。
 * 2, [[1,0]]
    */
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        Queue queue = new LinkedList();

        int count = 0;

        for (int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList();

        for (int i = 0; i < prerequisites.length; i++) {
            //出度，i节点 以 prerequisites[i][1] 为前置。
            degree[prerequisites[i][1]]++;
            //
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.add(i);
                count++;
            }
        }

        while (queue.size() != 0) {
            int course = (int) queue.poll();
            for (int i = 0; i < graph[course].size(); i++) {
                int pointer = (int) graph[course].get(i);
                //出度减一
                degree[pointer]--;
                if (degree[pointer] == 0) {
                    queue.add(pointer);
                    count++;
                }
            }
        }
        if (count == numCourses)
            return true;
        else
            return false;
    }

}
