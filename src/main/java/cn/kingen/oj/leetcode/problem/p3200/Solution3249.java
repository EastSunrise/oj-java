package cn.kingen.oj.leetcode.problem.p3200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/count-the-number-of-good-nodes/">3249. Count the Number of Good Nodes</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p500.Solution559
 */
@Question(
        difficulty = Difficulty.MEDIUM
)
public class Solution3249 {

    @Complexity(time = "O(n)", space = "O(n)")
    public int countGoodNodes(int[][] edges) {
        int n = edges.length + 1;
        List<List<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>(3));
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int[] ans = new int[1];
        dfs(graph, ans, -1, 0);
        return ans[0];
    }

    private int dfs(List<List<Integer>> graph, int[] ans, int p, int u) {
        int cnt = 0, total = 1;
        for (int v : graph.get(u)) {
            if (v == p) {
                continue;
            }
            int c = dfs(graph, ans, u, v);
            if (cnt == 0) { // first subtree
                cnt = c;
            } else if (cnt != -1 && cnt != c) { // bad node
                cnt = -1;
            }
            total += c;
        }
        if (cnt != -1) { // good node
            ans[0]++;
        }
        return total;
    }
}