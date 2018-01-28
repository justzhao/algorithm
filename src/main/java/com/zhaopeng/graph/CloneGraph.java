package com.zhaopeng.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/clone-graph/description/
 * Created by zhaopeng on 2018/1/23.
 */

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}

public class CloneGraph {

    private Map<Integer, UndirectedGraphNode> visited = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

        if (node == null) {
            return null;
        }
        if (visited.containsKey(node.label)) {
            return visited.get(node.label);
        }

        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        visited.put(node.label,node);
        for (UndirectedGraphNode neigh : node.neighbors) {
            root.neighbors.add(cloneGraph(neigh));
        }
        return root;
    }
}
