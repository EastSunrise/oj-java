package cn.kingen.oj.leetcode.problem.p1800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/minimum-skips-to-arrive-at-meeting-on-time/">1883. Minimum Skips to Arrive at Meeting On Time</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1800.Solution1870
 * @see cn.kingen.oj.leetcode.problem.p2100.Solution2188
 */
@Question(
        tags = {Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.HARD
)
public class Solution1883 {

    @Complexity(time = "O(n^2)", space = "O(n^2)")
    public int minSkips(int[] dist, int speed, int hoursBefore) {
        int n = dist.length;
        // dp[i][j]: the minimum time to reach end of i-th road skipping j times
        // represented by time * speed
        int[][] dp = new int[n][n + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        dp[0][0] = dist[0];
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[i][j] == Integer.MAX_VALUE) { // too many skips
                    continue;
                }
                // go through (i+1)-th road
                if (dp[i][j] % speed == 0) {
                    // go directly
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + dist[i + 1]);
                } else {
                    // not skip, calculate rest time as well
                    dp[i + 1][j] = Math.min(dp[i + 1][j], (dp[i][j] / speed + 1) * speed + dist[i + 1]);
                    // skip
                    dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i][j] + dist[i + 1]);
                }
            }
        }
        int total = hoursBefore * speed;
        for (int j = 0; j < n; j++) {
            if (dp[n - 1][j] <= total) {
                return j;
            }
        }
        return -1;
    }
}