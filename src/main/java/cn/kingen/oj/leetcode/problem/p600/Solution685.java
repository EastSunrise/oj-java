package cn.kingen.oj.leetcode.problem.p600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/redundant-connection-ii/">685. Redundant Connection II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p600.Solution684
 */
@Question(
        tags = {Tag.DEPTH_FIRST_SEARCH, Tag.BREADTH_FIRST_SEARCH, Tag.UNION_FIND, Tag.GRAPH},
        difficulty = Difficulty.HARD
)
public class Solution685 {

    @Complexity(time = "O(n*a(n))", space = "O(n)")
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parents = new int[n + 1];
        int[] dupEdge = null;
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (parents[v] == 0) {
                parents[v] = u;
            } else {
                dupEdge = edge;
            }
        }

        if (dupEdge == null) { // extra edge points to the root
            Arrays.setAll(parents, i -> i);
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1];
                if (find(parents, u) == v) { // found a cycle
                    return edge;
                }
                parents[v] = u;
            }
            throw new IllegalArgumentException("No cycle");
        }

        int[] dupEdge1 = new int[]{parents[dupEdge[1]], dupEdge[1]};
        Arrays.setAll(parents, i -> i);
        for (int[] edge : edges) {
            if (edge == dupEdge) { // skip the duplicate edge
                continue;
            }
            int pu = find(parents, edge[0]), pv = find(parents, edge[1]);
            if (pu == pv) { // found a connected
                return dupEdge1;
            }
            parents[pv] = pu;
        }
        return dupEdge;
    }

    private int find(int[] parents, int x) {
        if (parents[x] == x) {
            return x;
        }
        return parents[x] = find(parents, parents[x]);
    }
}