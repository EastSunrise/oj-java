package wsg.oj.java.leetcode.problems.p600;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p500.Solution576;

/**
 * 688. Knight Probability in Chessboard (MEDIUM)
 *
 * @author Kingen
 * @see Solution576
 * @see <a href="https://leetcode-cn.com/problems/knight-probability-in-chessboard/">Knight
 * Probability in Chessboard</a>
 * @since 2021-07-23
 */
public class Solution688 implements Solution {

    int[] dr = {-2, -1, 1, 2, 2, 1, -1, -2};
    int[] dc = {1, 2, 2, 1, -1, -2, -2, -1};

    /**
     * @complexity T=O(k*n^2)
     * @complexity S=O(k*n^2)
     * @see #DFS
     */
    public double knightProbability(int n, int k, int row, int column) {
        // dp[r][c][k]: paths of the knight on the board after k moves since [r,c]
        double[][][] dp = new double[n][n][k + 1];
        return move(dp, n, k, row, column);
    }

    private double move(double[][][] dp, int n, int k, int r, int c) {
        if (r < 0 || c < 0 || r >= n || c >= n) {
            return 0;
        }
        if (dp[r][c][k] == 0) {
            if (k == 0) {
                dp[r][c][k] = 1;
            } else {
                for (int i = 0; i < 8; i++) {
                    dp[r][c][k] += move(dp, n, k - 1, r + dr[i], c + dc[i]);
                }
                dp[r][c][k] /= 8.0;
            }
        }
        return dp[r][c][k];
    }
}
