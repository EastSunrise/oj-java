package cn.kingen.oj.leetcode.problem.p2900;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/number-of-possible-sets-of-closing-branches/">2959. Number of Possible Sets of Closing Branches</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.BIT_MANIPULATION, Tag.GRAPH, Tag.ENUMERATION, Tag.SHORTEST_PATH, Tag.HEAP_PRIORITY_QUEUE},
        difficulty = Difficulty.HARD
)
public class Solution2959 {

    @Complexity(time = "O(|E| + 2^n * n^3)", space = "O(n^2)")
    public int numberOfSets(int n, int maxDistance, int[][] roads) {
        final int unreachable = maxDistance + 1;
        int[][] graph = new int[n][n];
        for (int u = 0; u < n; u++) {
            Arrays.fill(graph[u], unreachable);
        }
        for (int[] road : roads) {
            int u = road[0], v = road[1], w = road[2];
            graph[u][v] = Math.min(graph[u][v], w);
            graph[v][u] = Math.min(graph[v][u], w);
        }

        int ans = 0;
        int[][] dp = new int[n][n];
        next:
        for (int s = 0, m = 1 << n; s < m; s++) {
            for (int u = 0; u < n; u++) {
                if ((s >> u & 1) == 1) {
                    System.arraycopy(graph[u], 0, dp[u], 0, n);
                }
            }

            for (int k = 0; k < n; k++) {
                if ((s >> k & 1) == 0) {
                    continue;
                }
                for (int u = 0; u < n; u++) {
                    if ((s >> u & 1) == 0) {
                        continue;
                    }
                    for (int v = 0; v < n; v++) {
                        dp[u][v] = Math.min(dp[u][v], dp[u][k] + dp[k][v]);
                    }
                }
            }

            for (int u = 0; u < n; u++) {
                if ((s >> u & 1) == 0) {
                    continue;
                }
                for (int v = 0; v < u; v++) {
                    if ((s >> v & 1) == 0) {
                        continue;
                    }
                    if (dp[u][v] > maxDistance) {
                        continue next;
                    }
                }
            }
            ans++;
        }
        return ans;
    }
}