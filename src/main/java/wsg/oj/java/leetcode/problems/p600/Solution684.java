package wsg.oj.java.leetcode.problems.p600;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 684. Redundant Connection (MEDIUM)
 *
 * @author Kingen
 * @see Solution685
 * @see Solution721
 * @see <a href="https://leetcode-cn.com/problems/redundant-connection/">Redundant Connection</a>
 * @since 2021-07-23
 */
class Solution684 implements Solution {

    /**
     * Union and find.
     *
     * @see wsg.oj.java.Complexity#TIME_N_LOG_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parents = new int[n + 1], height = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }
        for (int[] edge : edges) {
            int r1 = find(parents, edge[0]);
            int r2 = find(parents, edge[1]);
            if (r1 != r2) {
                union(parents, height, r1, r2);
            } else {
                return edge;
            }
        }
        throw new IllegalArgumentException("No cycle");
    }

    private void union(int[] parents, int[] height, int u, int v) {
        if (height[u] > height[v]) {
            parents[v] = u;
            height[v] = 0;
        } else {
            parents[u] = v;
            if (height[u] == height[v]) {
                height[v]++;
            }
            height[u] = 0;
        }
    }

    private int find(int[] parents, int v) {
        while (v != parents[v]) {
            v = parents[v];
        }
        return v;
    }
}
