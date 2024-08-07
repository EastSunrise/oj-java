package cn.kingen.oj.leetcode.problem.p2100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/detonate-the-maximum-bombs/">2101. Detonate the Maximum Bombs</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p500.Solution529
 * @see cn.kingen.oj.leetcode.problem.p500.Solution547
 * @see cn.kingen.oj.leetcode.problem.p600.Solution695
 * @see cn.kingen.oj.leetcode.problem.p900.Solution994
 */
@Question(
        tags = {Tag.DEPTH_FIRST_SEARCH, Tag.BREADTH_FIRST_SEARCH, Tag.GRAPH, Tag.GEOMETRY, Tag.ARRAY, Tag.MATH},
        difficulty = Difficulty.MEDIUM
)
public class Solution2101 {

    @Complexity(time = "O(n^3)", space = "O(n^2)")
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<List<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            long x = bombs[i][0], y = bombs[i][1], rr = (long) bombs[i][2] * bombs[i][2];
            for (int j = i + 1; j < n; j++) {
                long dx = bombs[j][0] - x, dy = bombs[j][1] - y;
                long d = dx * dx + dy * dy;
                if (d <= rr) {
                    graph.get(i).add(j);
                }
                if (d <= (long) bombs[j][2] * bombs[j][2]) {
                    graph.get(j).add(i);
                }
            }
        }

        int max = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited, false);
            max = Math.max(max, dfs(graph, visited, i));
        }
        return max;
    }

    private int dfs(List<List<Integer>> graph, boolean[] visited, int u) {
        int cnt = 1;
        visited[u] = true;
        for (int v : graph.get(u)) {
            if (!visited[v]) {
                cnt += dfs(graph, visited, v);
            }
        }
        return cnt;
    }
}