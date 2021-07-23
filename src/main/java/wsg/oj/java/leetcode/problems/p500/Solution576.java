package wsg.oj.java.leetcode.problems.p500;

import java.util.Arrays;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 576. Out of Boundary Paths (MEDIUM)
 *
 * @author Kingen
 * @see Solution688
 * @see <a href="https://leetcode-cn.com/problems/out-of-boundary-paths/">Out of Boundary Paths</a>
 * @since 2021-07-20
 */
class Solution576 implements Solution {

    long mod = 1_000_000_007;

    /**
     * @complexity T=O(mnN), N=maxMove
     * @complexity S=O(mnN)
     */
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        long[][][] dp = new long[m][n][maxMove + 1];
        for (long[][] row : dp) {
            for (long[] col : row) {
                Arrays.fill(col, -1);
            }
        }
        return (int) move(dp, m, n, maxMove, startRow, startColumn);
    }

    private long move(long[][][] dp, int m, int n, int moves, int r, int c) {
        if (r < 0 || c < 0 || r == m || c == n) {
            return 1;
        }
        if (dp[r][c][moves] >= 0) {
            return dp[r][c][moves];
        }
        if (moves == 0) {
            dp[r][c][0] = 0;
            return 0;
        }
        long count = 0;
        count += move(dp, m, n, moves - 1, r - 1, c);
        count += move(dp, m, n, moves - 1, r, c - 1);
        count += move(dp, m, n, moves - 1, r + 1, c);
        count += move(dp, m, n, moves - 1, r, c + 1);
        count %= mod;
        dp[r][c][moves] = count;
        return count;
    }
}
