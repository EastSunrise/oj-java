package cn.wsg.oj.leetcode.problems.interview.ch4;

import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 面试题 4.1. Route Between Nodes LCCI (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/route-between-nodes-lcci/">Route Between Nodes
 * LCCI</a>
 */
public class Interview1 implements Solution {

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        Map<Integer, Set<Integer>> edges = new HashMap<>();
        for (int[] edge : graph) {
            edges.computeIfAbsent(edge[0], key -> new HashSet<>()).add(edge[1]);
        }
        return dfs(edges, new HashSet<>(), start, target);
    }

    private boolean dfs(Map<Integer, Set<Integer>> edges, Set<Integer> visited, int u, int target) {
        if (u == target) {
            return true;
        }
        if (visited.contains(u)) {
            return false;
        }
        visited.add(u);
        if (edges.containsKey(u)) {
            for (int v : edges.get(u)) {
                if (dfs(edges, visited, v, target)) {
                    return true;
                }
            }
        }
        return false;
    }
}
