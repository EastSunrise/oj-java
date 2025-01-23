package cn.kingen.oj.leetcode.problem.p2900;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/maximum-points-after-collecting-coins-from-all-nodes/">2920. Maximum Points After Collecting Coins From All Nodes</a>
 *
 * @author Kingen

 */
@Question(
        tags = {Tag.BIT_MANIPULATION, Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.HARD,
        daily = "2025-01-23"
)
public class Solution2920 {

    @Complexity(time = "O(n*log(C))", space = "O(n*log(C))", note = "C is the maximum of coins")
    public int maximumPoints(int[][] edges, int[] coins, int k) {
        int n = edges.length + 1;
        List<Integer>[] graph = new List[n];
        Arrays.setAll(graph, i -> new ArrayList<>());
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int[][] memo = new int[n][14];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }
        return maxPoint(memo, graph, coins, k, -1, 0, 0);
    }

    private int maxPoint(int[][] memo, List<Integer>[] graph, int[] coins, int k, int p, int u, int shift) {
        if (shift >= 14) {
            return 0;
        }
        if (memo[u][shift] != -1) {
            return memo[u][shift];
        }

        int score1 = (coins[u] >> shift) - k;
        int score2 = coins[u] >> (shift + 1);
        for (int v : graph[u]) {
            if (v == p) {
                continue;
            }
            score1 += maxPoint(memo, graph, coins, k, u, v, shift);
            score2 += maxPoint(memo, graph, coins, k, u, v, shift + 1);
        }
        return (memo[u][shift] = Math.max(score1, score2));
    }
}