package cn.kingen.oj.leetcode.problem.p700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/cherry-pickup/">741. Cherry Pickup</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution64
 * @see cn.kingen.oj.leetcode.problem.p100.Solution174
 */
@Question(
        tags = {Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING, Tag.MATRIX},
        difficulty = Difficulty.HARD
)
public class Solution741 {

    @Complexity(time = "O(n^3)", space = "O(n^3)")
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        // dp[i1][i2][k]: max cherries when A arrives at (i1, k-i1) and B at (i2, k-i2)
        int[][][] dp = new int[n + n - 1][n][n];
        for (int k = 0, kl = n + n - 1; k < kl; k++) {
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[k][i], Integer.MIN_VALUE);
            }
        }
        dp[0][0][0] = grid[0][0];
        for (int k = 1, kl = n + n - 1; k < kl; k++) {
            int m = Math.min(n - 1, k);
            for (int i1 = Math.max(0, k - n + 1); i1 <= m; i1++) {
                int j1 = k - i1;
                if (grid[i1][j1] == -1) {
                    continue;
                }
                for (int i2 = i1; i2 <= m; i2++) {
                    int j2 = k - i2;
                    if (grid[i2][j2] == -1) {
                        continue;
                    }
                    int cnt = dp[k - 1][i1][i2]; // A goes right and B goes right
                    if (i1 > 0) { // A goes down and B goes right
                        cnt = Math.max(cnt, dp[k - 1][i1 - 1][i2]);
                    }
                    if (i2 > 0) { // A goes right and B goes down
                        cnt = Math.max(cnt, dp[k - 1][i1][i2 - 1]);
                    }
                    if (i1 > 0) { // A goes down and B goes down
                        cnt = Math.max(cnt, dp[k - 1][i1 - 1][i2 - 1]);
                    }
                    cnt += grid[i1][j1];
                    if (i1 != i2) { // A and B pick different cherries
                        cnt += grid[i2][j2];
                    }
                    dp[k][i1][i2] = cnt;
                }
            }
        }
        return Math.max(dp[n + n - 2][n - 1][n - 1], 0);
    }
}