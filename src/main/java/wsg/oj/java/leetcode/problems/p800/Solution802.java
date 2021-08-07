package wsg.oj.java.leetcode.problems.p800;

import java.util.ArrayList;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 802. Find Eventual Safe States (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/find-eventual-safe-states/">Find Eventual Safe
 * States</a>
 * @since 2021-07-27
 */
public class Solution802 implements Solution {

    /**
     * @complexity T=O(m+n), m=|V|, n=|E|
     * @complexity S=O(m)
     */
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> res = new ArrayList<>();
        boolean[] safes = new boolean[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (isSafe(graph, safes, visited, i)) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean isSafe(int[][] graph, boolean[] safes, boolean[] visited, int u) {
        if (visited[u]) {
            return safes[u];
        }
        // mark the vertex as visited
        visited[u] = true;
        for (int v : graph[u]) {
            if (!isSafe(graph, safes, visited, v)) {
                return false;
            }
        }
        return safes[u] = true;
    }
}
