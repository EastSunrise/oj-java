package cn.kingen.oj.leetcode.problem.p100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/">121. Best Time to Buy and Sell Stock</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution53
 * @see cn.kingen.oj.leetcode.problem.p100.Solution122
 * @see cn.kingen.oj.leetcode.problem.p100.Solution123
 * @see cn.kingen.oj.leetcode.problem.p100.Solution188
 * @see cn.kingen.oj.leetcode.problem.p300.Solution309
 */
@Question(
        tags = {Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.EASY
)
public class Solution121 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int maxProfit(int[] prices) {
        // min: the min price within prices[0,i-1]
        int min = prices[0], ans = 0, n = prices.length;
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return ans;
    }
}