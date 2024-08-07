package cn.kingen.oj.leetcode.problem.p100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/">122. Best Time to Buy and Sell Stock II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution121
 * @see cn.kingen.oj.leetcode.problem.p100.Solution123
 * @see cn.kingen.oj.leetcode.problem.p100.Solution188
 * @see cn.kingen.oj.leetcode.problem.p300.Solution309
 * @see cn.kingen.oj.leetcode.problem.p700.Solution714
 */
@Question(
        tags = {Tag.GREEDY, Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.MEDIUM
)
public class Solution122 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }
}