package cn.kingen.oj.leetcode.problem.p3000;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.List;

import static cn.kingen.oj.leetcode.util.GraphUtils.buildWeightedGraph;

/**
 * <a href="https://leetcode.cn/problems/count-pairs-of-connectable-servers-in-a-weighted-tree-network/">3067. Count Pairs of Connectable Servers in a Weighted Tree Network</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p300.Solution310
 * @see cn.kingen.oj.leetcode.problem.p800.Solution834
 */
@Question(
        tags = {Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.ARRAY},
        difficulty = Difficulty.MEDIUM
)
public class Solution3067 {

    @Complexity(time = "O(n^2)", space = "O(n)")
    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        int n = edges.length + 1;
        List<List<int[]>> graph = buildWeightedGraph(edges, n);
        int[] ans = new int[n];
        for (int c = 0; c < n; c++) {
            int sum = 0;
            for (int[] e : graph.get(c)) {
                int cnt = dfs(graph, c, e[0], e[1], signalSpeed);
                ans[c] += sum * cnt;
                sum += cnt;
            }
        }
        return ans;
    }

    private int dfs(List<List<int[]>> graph, int p, int u, int dist, int signalSpeed) {
        int cnt = dist % signalSpeed == 0 ? 1 : 0;
        for (int[] edge : graph.get(u)) {
            int v = edge[0], w = edge[1];
            if (v != p) {
                cnt += dfs(graph, u, v, dist + w, signalSpeed);
            }
        }
        return cnt;
    }
}