package cn.kingen.oj.leetcode.problem.p700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/">714. Best Time to Buy and Sell Stock with Transaction Fee</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution122
 */
@Question(
        tags = {Tag.GREEDY, Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.MEDIUM
)
public class Solution714 {

    @Complexity(time = "O(n)", space = "O(1)")
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