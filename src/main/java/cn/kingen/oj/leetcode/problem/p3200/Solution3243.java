package cn.kingen.oj.leetcode.problem.p3200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/shortest-distance-after-road-addition-queries-i/">3243. Shortest Distance After Road Addition Queries I</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.BREADTH_FIRST_SEARCH, Tag.GRAPH, Tag.ARRAY},
        difficulty = Difficulty.MEDIUM
)
public class Solution3243 {

    @Complexity(time = "O(m*n*n)", space = "O(n^2)")
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int m = queries.length;
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                dist[i][j] = j - i;
            }
        }

        int[] ans = new int[m];
        for (int k = 0; k < m; k++) {
            int u = queries[k][0], v = queries[k][1];
            for (int i = 0; i <= u; i++) {
                for (int j = v; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][u] + dist[v][j] + 1);
                }
            }
            ans[k] = dist[0][n - 1];
        }
        return ans;
    }
}