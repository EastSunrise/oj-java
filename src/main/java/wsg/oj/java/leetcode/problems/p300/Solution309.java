package wsg.oj.java.leetcode.problems.p300;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p100.Solution121;
import wsg.oj.java.leetcode.problems.p100.Solution122;

/**
 * 309. Best Time to Buy and Sell Stock with Cooldown (Medium)
 *
 * @author Kingen
 * @see Solution121
 * @see Solution122
 * @see <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/">Best
 * Time to Buy and Sell Stock with Cooldown</a>
 * @since 2021-07-13
 */
public class Solution309 implements Solution {

    /**
     * @see #DYNAMIC_PROGRAMMING
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }
        // held[i]: the max profit when holding a stock after i days
        int[] held = new int[n];
        // cooldown[i]: the max profit when in cooldown after i days
        int[] cooldown = new int[n];
        // free[i]: the max profit when free to trade after i days
        int[] free = new int[n];
        held[0] = -prices[0];
        for (int i = 1; i < n; i++) {
            held[i] = Math.max(held[i - 1], free[i - 1] - prices[i]);
            cooldown[i] = held[i - 1] + prices[i];
            free[i] = Math.max(free[i - 1], cooldown[i - 1]);
        }
        return Math.max(cooldown[n - 1], free[n - 1]);
    }
}
