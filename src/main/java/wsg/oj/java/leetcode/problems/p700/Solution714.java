package wsg.oj.java.leetcode.problems.p700;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p100.Solution122;

/**
 * 714. Best Time to Buy and Sell Stock with Transaction Fee (MEDIUM)
 *
 * @author Kingen
 * @see Solution122
 * @see <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/">Best
 * Time to Buy and Sell Stock with Transaction Fee</a>
 * @since 2021-07-27
 */
public class Solution714 implements Solution {

    /**
     * @see #DYNAMIC_PROGRAMMING
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        // held: the max profit when holding a stock after trading
        // sold: the max profit when selling a stock after trading
        int held = -prices[0], sold = 0, tmp;
        for (int i = 1; i < n; i++) {
            tmp = held;
            held = Math.max(held, sold - prices[i]);
            sold = Math.max(sold, tmp + prices[i] - fee);
        }
        return sold;
    }
}
