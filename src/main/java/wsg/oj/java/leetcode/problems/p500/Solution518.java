package wsg.oj.java.leetcode.problems.p500;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 518. Coin Change 2 (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/coin-change-2/">Coin Change 2</a>
 * @since 2021-07-20
 */
class Solution518 implements Solution {

    /**
     * @see #DYNAMIC_PROGRAMMING
     * @see wsg.oj.java.Complexity#TIME_MN
     * @see wsg.oj.java.Complexity#SPACE_MN
     */
    public int change(int amount, int[] coins) {
        int n = coins.length;
        // dp[i][j]: the number of combinations of coins[0,i] that make up amount j.
        int[][] dp = new int[n][amount + 1];
        for (int j = 0; j <= amount; j += coins[0]) {
            // the first coin
            dp[0][j] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j < coins[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]];
                }
            }
        }
        return dp[n - 1][amount];
    }

    /**
     * @see #DYNAMIC_PROGRAMMING
     * @see wsg.oj.java.Complexity#TIME_MN
     * @see wsg.oj.java.Complexity#SPACE_M
     */
    public int change2(int amount, int[] coins) {
        // dp[j]: the number of combinations of coins[0,i] that make up amount j.
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }
}
