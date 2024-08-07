package cn.kingen.oj.leetcode.problem.p1400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/cherry-pickup-ii/">1463. Cherry Pickup II</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING, Tag.MATRIX},
        difficulty = Difficulty.HARD
)
public class Solution1463 {

    @Complexity(time = "O(m*n^2)", space = "O(m*n^2)")
    public int cherryPickup(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // dp[i][j1][j2]: the maximum number of cherries when A arrives at (i, j1) and B arrives at (i, j2)
        int[][][] dp = new int[m][n][n];
        dp[0][0][n - 1] = grid[0][0] + grid[0][n - 1];
        for (int i = 1; i < m; i++) {
            for (int j1 = 0, j1l = Math.min(i, n - 1); j1 <= j1l; j1++) {
                for (int j2 = n - 1, j2l = Math.max(0, n - 1 - i); j2 >= j2l; j2--) {
                    int max = 0;
                    for (int d1 = -1; d1 <= 1; d1++) {
                        for (int d2 = -1; d2 <= 1; d2++) {
                            int y1 = j1 + d1, y2 = j2 + d2;
                            if (y1 >= 0 && y1 < n && y2 >= 0 && y2 < n) {
                                max = Math.max(max, dp[i - 1][y1][y2]);
                            }
                        }
                    }
                    dp[i][j1][j2] = max + grid[i][j1] + (j1 != j2 ? grid[i][j2] : 0);
                }
            }
        }
        int ans = 0;
        for (int j1 = 0; j1 < n; j1++) {
            for (int j2 = 0; j2 < n; j2++) {
                ans = Math.max(ans, dp[m - 1][j1][j2]);
            }
        }
        return ans;
    }
}