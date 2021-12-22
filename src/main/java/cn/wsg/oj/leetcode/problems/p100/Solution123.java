package cn.wsg.oj.leetcode.problems.p100;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 123. Best Time to Buy and Sell Stock III (HARD)
 *
 * @author Kingen
 * @see Solution121
 * @see Solution122
 * @see Solution188
 * @see Solution689
 * @see <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/">Best Time to
 * Buy and Sell Stock III</a>
 */
public class Solution123 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        // the max profit of completing the transaction (first buy/sell, second buy/sell)
        // within [0,i]
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // seconds[i]: the max profit of the second transaction within [i,n)
        int[] seconds = new int[n + 1];
        int secondProfit = 0, max = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (prices[i] >= max) {
                max = prices[i];
            } else {
                secondProfit = Math.max(secondProfit, max - prices[i]);
            }
            seconds[i] = secondProfit;
        }
        int firstProfit = 0, min = prices[0], maxProfit = secondProfit;
        for (int i = 1; i < n; i++) {
            if (prices[i] <= min) {
                min = prices[i];
            } else {
                firstProfit = Math.max(firstProfit, prices[i] - min);
            }
            // complete the first transaction within [0,i]
            // and the second one within [i+1,n)
            maxProfit = Math.max(maxProfit, firstProfit + seconds[i + 1]);
        }
        return maxProfit;
    }
}
