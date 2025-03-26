package cn.kingen.oj.leetcode.problem.p3300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * <a href="https://leetcode.cn/problems/remove-methods-from-project/">3310. Remove Methods From Project</a>
 *
 * @author Kingen

 */
@Question(
        tags = {Tag.DEPTH_FIRST_SEARCH, Tag.BREADTH_FIRST_SEARCH, Tag.GRAPH},
        difficulty = Difficulty.MEDIUM,
        contest = 418
)
public class Solution3310 {

    @Complexity(time = "O(|E|+|V|)", space = "O(|E|+|V|)")
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : invocations) {
            graph.get(edge[0]).add(edge[1]);
        }

        boolean[] removed = new boolean[n];
        dfs(graph, removed, k);

        for (int[] edge : invocations) {
            if (!removed[edge[0]] && removed[edge[1]]) {
                return IntStream.range(0, n).boxed().toList();
            }
        }

        return IntStream.range(0, n).filter(i -> !removed[i]).boxed().toList();
    }

    private void dfs(List<List<Integer>> graph, boolean[] removed, int u) {
        removed[u] = true;
        for (int v : graph.get(u)) {
            if (!removed[v]) {
                dfs(graph, removed, v);
            }
        }
    }
}