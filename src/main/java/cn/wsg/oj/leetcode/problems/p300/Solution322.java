package cn.wsg.oj.leetcode.problems.p300;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p900.Solution983;
import java.util.Arrays;

/**
 * 322. Coin Change (Medium)
 *
 * @author Kingen
 * @see Solution983
 * @see <a href="https://leetcode-cn.com/problems/coin-change/">Coin Change</a>
 */
public class Solution322 implements Solution {

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
