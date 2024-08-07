package cn.kingen.oj.leetcode.problem.p100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/">123. Best Time to Buy and Sell Stock III</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution121
 * @see cn.kingen.oj.leetcode.problem.p100.Solution122
 * @see cn.kingen.oj.leetcode.problem.p100.Solution188
 * @see cn.kingen.oj.leetcode.problem.p600.Solution689
 */
@Question(
        tags = {Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.HARD
)
public class Solution123 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int maxProfit(int[] prices) {
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
}