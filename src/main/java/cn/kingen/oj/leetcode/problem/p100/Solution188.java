package cn.kingen.oj.leetcode.problem.p100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/">188. Best Time to Buy and Sell Stock IV</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution121
 * @see cn.kingen.oj.leetcode.problem.p100.Solution122
 * @see cn.kingen.oj.leetcode.problem.p100.Solution123
 */
@Question(
        tags = {Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.HARD
)
public class Solution188 {

    @Complexity(time = "O(nk)", space = "O(k)")
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        // buy[i]: the max profit after i-1 transactions and a buying operation
        // sell[i]: the max profit after i transactions
        int[] buy = new int[k + 1], sell = new int[k + 1];
        Arrays.fill(buy, -prices[0]);
        for (int i = 1; i < n; i++) {
            int price = prices[i];
            for (int j = 0; j < k; j++) {
                buy[j + 1] = Math.max(buy[j + 1], sell[j] - price);
                sell[j + 1] = Math.max(sell[j + 1], buy[j + 1] + price);
            }
        }
        return sell[k];
    }
}