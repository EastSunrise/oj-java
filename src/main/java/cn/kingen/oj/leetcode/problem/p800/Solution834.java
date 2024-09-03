package cn.kingen.oj.leetcode.problem.p800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.List;

import static cn.kingen.oj.leetcode.util.GraphUtils.buildUndirectedGraph;

/**
 * <a href="https://leetcode.cn/problems/sum-of-distances-in-tree/">834. Sum of Distances in Tree</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p900.Solution979
 * @see cn.kingen.oj.leetcode.problem.p2000.Solution2049
 * @see cn.kingen.oj.leetcode.problem.p2600.Solution2603
 * @see cn.kingen.oj.leetcode.problem.p2900.Solution2925
 * @see cn.kingen.oj.leetcode.problem.p3000.Solution3067
 */
@Question(
        tags = {Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.GRAPH, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.HARD
)
public class Solution834 {

    @Complexity(time = "O(n)", space = "O(n)")
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        List<List<Integer>> graph = buildUndirectedGraph(edges, n);
        // sizes[i]: number of nodes in subtree with node-i as root;
        int[] ans = new int[n], sizes = new int[n];
        dfs(graph, ans, sizes, -1, 0, 0);
        dfs(graph, ans, sizes, -1, 0);
        return ans;
    }

    private int dfs(List<List<Integer>> graph, int[] ans, int[] sizes, int p, int u, int d) {
        ans[0] += d;
        int size = 1;
        for (int v : graph.get(u)) {
            if (v != p) {
                size += dfs(graph, ans, sizes, u, v, d + 1);
            }
        }
        return sizes[u] = size;
    }

    private void dfs(List<List<Integer>> graph, int[] ans, int[] sizes, int p, int u) {
        for (int v : graph.get(u)) {
            if (v != p) {
                ans[v] = ans[u] + graph.size() - 2 * sizes[v];
                dfs(graph, ans, sizes, u, v);
            }
        }
    }
}