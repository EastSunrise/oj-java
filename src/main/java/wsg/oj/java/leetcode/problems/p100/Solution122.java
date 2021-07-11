package wsg.oj.java.leetcode.problems.p100;

import wsg.oj.java.leetcode.problems.base.Solution;

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
 * @since 2021-07-11
 */
class Solution122 implements Solution {

    /**
     * @see #DYNAMIC_PROGRAMMING
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int profit = 0, min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                profit += prices[i - 1] - min;
                min = prices[i];
            }
        }
        profit += prices[prices.length - 1] - min;
        return profit;
    }
}
