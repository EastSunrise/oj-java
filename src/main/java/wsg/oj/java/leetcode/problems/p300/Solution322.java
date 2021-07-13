package wsg.oj.java.leetcode.problems.p300;

import java.util.Arrays;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 322. Coin Change (Medium)
 *
 * @author Kingen
 * @see Solution983
 * @see <a href="https://leetcode-cn.com/problems/coin-change/">Coin Change</a>
 * @since 2021-07-04
 */
class Solution322 implements Solution {

    /**
     * @complexity T=O(nk), k=the amount
     * @complexity S=O(k)
     * @see #DYNAMIC_PROGRAMMING
     */
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }
}
