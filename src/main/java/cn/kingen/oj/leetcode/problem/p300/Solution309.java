package cn.kingen.oj.leetcode.problem.p300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/">309. Best Time to Buy and Sell Stock with Cooldown</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution121
 * @see cn.kingen.oj.leetcode.problem.p100.Solution122
 */
@Question(
        tags = {Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.MEDIUM
)
public class Solution309 {

    @Complexity(time = "O(n)", space = "O(n)")
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