package cn.kingen.oj.leetcode.problem.p2500;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static cn.kingen.oj.leetcode.util.GraphUtils.buildUndirectedGraph;

/**
 * <a href="https://leetcode.cn/problems/count-number-of-possible-root-nodes/">2581. Count Number of Possible Root Nodes</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2200.Solution2277
 */
@Question(
        tags = {Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.HASH_TABLE, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.HARD
)
public class Solution2581 {

    @Complexity(time = "O(m+n)", space = "O(m+n)")
    public int rootCount(int[][] edges, int[][] guesses, int k) {
        int n = edges.length + 1;
        List<List<Integer>> graph = buildUndirectedGraph(edges, n);
        List<Set<Integer>> guessed = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            guessed.add(new HashSet<>());
        }
        for (int[] guess : guesses) {
            guessed.get(guess[0]).add(guess[1]);
        }

        int cnt0 = dfs(graph, guessed, -1, 0);
        return dfs(graph, guessed, k, -1, 0, cnt0);
    }

    private int dfs(List<List<Integer>> graph, List<Set<Integer>> guessed, int k, int p, int u, int uCnt) {
        int ans = uCnt >= k ? 1 : 0;
        for (int v : graph.get(u)) {
            if (v != p) {
                int vCnt = uCnt;
                if (guessed.get(u).contains(v)) {
                    vCnt--;
                }
                if (guessed.get(v).contains(u)) {
                    vCnt++;
                }
                ans += dfs(graph, guessed, k, u, v, vCnt);
            }
        }
        return ans;
    }

    private int dfs(List<List<Integer>> graph, List<Set<Integer>> guessed, int p, int u) {
        int cnt = 0;
        for (int v : graph.get(u)) {
            if (v != p) {
                if (guessed.get(u).contains(v)) {
                    cnt++;
                }
                cnt += dfs(graph, guessed, u, v);
            }
        }
        return cnt;
    }
}