package wsg.oj.java.leetcode.problems.p700;

import java.util.ArrayList;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 797. All Paths From Source to Target (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/all-paths-from-source-to-target/">All Paths From
 * Source to Target</a>
 * @since 2021-07-27
 */
public class Solution797 implements Solution {

    /**
     * @see #DFS
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, graph, graph.length, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[][] graph, int n, List<Integer> path, int u) {
        path.add(u);
        if (u == n - 1) {
            // reach the last vertex
            res.add(new ArrayList<>(path));
        } else {
            for (int v : graph[u]) {
                dfs(res, graph, n, path, v);
            }
        }
        path.remove(path.size() - 1);
    }
}
