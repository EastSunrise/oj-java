package cn.kingen.oj.leetcode.problem.p3200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/shortest-distance-after-road-addition-queries-ii/">3244. Shortest Distance After Road Addition Queries II</a>
 *
 * @author Kingen
 */
@Question(
    tags = {Tag.GREEDY, Tag.GRAPH, Tag.ARRAY, Tag.ORDERED_SET},
    difficulty = Difficulty.HARD
)
public class Solution3244 {

    @Complexity(time = "O(m+n)", space = "O(n)")
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int m = queries.length;
        int[] next = new int[n];
        for (int i = 0; i < n; i++) {
            next[i] = i + 1;
        }
        int[] ans = new int[m];
        int dist = n - 1;
        for (int i = 0; i < m; i++) {
            int u = queries[i][0], v = queries[i][1];
            int k = next[u], t;
            while (k != -1 && k < v) {
                t = next[k];
                next[k] = -1;
                k = t;
                dist--;
            }
            next[u] = v;
            ans[i] = dist;
        }
        return ans;
    }
}