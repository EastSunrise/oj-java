package cn.kingen.oj.leetcode.problem.p300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import static cn.kingen.oj.leetcode.util.GraphUtils.buildUndirectedGraph;

/**
 * <a href="https://leetcode.cn/problems/minimum-height-trees/">310. Minimum Height Trees</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution207
 * @see cn.kingen.oj.leetcode.problem.p200.Solution210
 * @see cn.kingen.oj.leetcode.problem.p2600.Solution2603
 * @see cn.kingen.oj.leetcode.problem.p3000.Solution3067
 */
@Question(
        tags = {Tag.DEPTH_FIRST_SEARCH, Tag.BREADTH_FIRST_SEARCH, Tag.GRAPH, Tag.TOPOLOGICAL_SORT},
        difficulty = Difficulty.MEDIUM
)
public class Solution310 {

    @Complexity(time = "O(n)", space = "O(n)")
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return List.of(0);
        }
        List<List<Integer>> graph = buildUndirectedGraph(edges, n);
        int[] degrees = new int[n];
        Queue<Integer> leaves = new ArrayDeque<>();
        for (int u = 0; u < n; u++) {
            degrees[u] = graph.get(u).size();
            if (degrees[u] == 1) {
                leaves.offer(u);
            }
        }

        int remaining = n;
        while (remaining > 2) {
            int size = leaves.size();
            for (int i = 0; i < size; i++) {
                int u = leaves.remove();
                for (int v : graph.get(u)) {
                    degrees[v]--;
                    if (degrees[v] == 1) {
                        leaves.offer(v);
                    }
                }
            }
            remaining -= size;
        }
        return new ArrayList<>(leaves);
    }
}