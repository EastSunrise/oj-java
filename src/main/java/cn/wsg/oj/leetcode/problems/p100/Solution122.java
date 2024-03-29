package cn.wsg.oj.leetcode.problems.p100;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p300.Solution309;
import cn.wsg.oj.leetcode.problems.p700.Solution714;

/**
 * 122. Best Time to Buy and Sell Stock II (Easy)
 *
 * @author Kingen
 * @see Solution121
 * @see Solution123
 * @see Solution188
 * @see Solution309
 * @see Solution714
 * @see <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/">Best Time to
 * Buy and Sell Stock II</a>
 */
public class Solution122 implements Solution {

    /**
     * @see #DYNAMIC_PROGRAMMING
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // held: the max profit when holding a stock after trading
        // sold: the max profit when selling a stock after trading
        int held = -prices[0], sold = 0, tmp;
        for (int i = 1; i < n; i++) {
            tmp = held;
            held = Math.max(held, sold - prices[i]);
            sold = Math.max(sold, tmp + prices[i]);
        }
        return sold;
    }

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public int maxProfit2(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
