package wsg.oj.java.leetcode.problems.p800;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 877. Stone Game (MEDIUM)
 *
 * @author Kingen
 * @see Solution1563
 * @see Solution1686
 * @see Solution1690
 * @see Solution1872
 * @see <a href="https://leetcode-cn.com/problems/stone-game/">Stone Game</a>
 * @since 2021-07-27
 */
public class Solution877 implements Solution {

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        // dp[i][j]: the maximal difference of stones the two players can take from piles[i,j]
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }
        for (int k = 1; k < n; k++) {
            for (int i = 0, max = n - k; i < max; i++) {
                // piles[i, i+k]
                int j = i + k;
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] > 0;
    }
}
