package cn.kingen.oj.leetcode.problem.p2000;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.List;

import static cn.kingen.oj.leetcode.util.GraphUtils.buildWeightedGraph;

/**
 * <a href="https://leetcode.cn/problems/maximum-path-quality-of-a-graph/">2065. Maximum Path Quality of a Graph</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p700.Solution741
 * @see cn.kingen.oj.leetcode.problem.p1900.Solution1928
 */
@Question(
        tags = {Tag.GRAPH, Tag.ARRAY, Tag.BACKTRACKING},
        difficulty = Difficulty.HARD
)
public class Solution2065 {

    @Complexity(time = "O(n+|V|+4^k)", space = "O(n+|V|+k)", note = "k is the number of nodes on the path")
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        int n = values.length;
        List<List<int[]>> graph = buildWeightedGraph(edges, n);
        return dfs(graph, values, new int[n], 0, maxTime);
    }

    private int dfs(List<List<int[]>> graph, int[] values, int[] count, int u, int time) {
        if (time < 0) {
            return -1;
        }
        count[u]++; // mark visit count
        int max = -1;
        for (int[] edge : graph.get(u)) {
            int v = edge[0], t = edge[1];
            max = Math.max(max, dfs(graph, values, count, v, time - t));
        }
        count[u]--;

        int value = count[u] > 0 ? 0 : values[u];
        if (max != -1) { // a valid path
            return max + value;
        }
        if (u == 0) { // as the end of a valid path
            return value;
        }
        return -1;
    }
}