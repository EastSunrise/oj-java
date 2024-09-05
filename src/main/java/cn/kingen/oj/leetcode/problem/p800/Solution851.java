package cn.kingen.oj.leetcode.problem.p800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/loud-and-rich/">851. Loud and Rich</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2300.Solution2392
 */
@Question(
        tags = {Tag.DEPTH_FIRST_SEARCH, Tag.GRAPH, Tag.TOPOLOGICAL_SORT, Tag.ARRAY},
        difficulty = Difficulty.MEDIUM
)
public class Solution851 {

    /**
     * Topological Sort.
     */
    @Complexity(time = "O(n+m)", space = "O(n+m)", note = "m is the length of richer")
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        List<List<Integer>> graph = new ArrayList<>(n);
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : richer) { // richer -> poorer
            int a = edge[0], b = edge[1];
            graph.get(a).add(b);
            indegree[b]++;
        }

        int[] ans = new int[n];
        for (int p = 0; p < n; p++) {
            ans[p] = p;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int u = 0; u < n; u++) {
            if (indegree[u] == 0) {
                queue.offer(u);
            }
        }

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : graph.get(u)) {
                if (quiet[ans[u]] < quiet[ans[v]]) { // update quietness of v by richer u
                    ans[v] = ans[u];
                }
                if (--indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        return ans;
    }

    @Complexity(time = "O(n+m)", space = "O(n+m)", note = "m is the length of richer")
    public int[] loudAndRich2(int[][] richer, int[] quiet) {
        int n = quiet.length;
        List<List<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : richer) { // poorer -> richer
            int a = edge[0], b = edge[1];
            graph.get(b).add(a);
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int u = 0; u < n; u++) {
            dfs(graph, quiet, ans, u);
        }
        return ans;
    }

    private int dfs(List<List<Integer>> graph, int[] quiet, int[] ans, int u) {
        if (ans[u] != -1) {
            return ans[u];
        }
        int y = u, min = quiet[u];
        for (int v : graph.get(u)) { // richer persons
            int p = dfs(graph, quiet, ans, v);
            if (quiet[p] < min) {
                min = quiet[p];
                y = p;
            }
        }
        return ans[u] = y;
    }
}