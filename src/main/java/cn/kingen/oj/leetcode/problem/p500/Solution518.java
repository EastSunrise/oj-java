package cn.kingen.oj.leetcode.problem.p500;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/coin-change-ii/">518. Coin Change II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2200.Solution2218
 * @see cn.kingen.oj.leetcode.problem.p2500.Solution2585
 * @see cn.kingen.oj.leetcode.problem.p2900.Solution2902
 * @see cn.kingen.oj.leetcode.problem.p2900.Solution2915
 */
@Question(
        tags = {Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.MEDIUM
)
public class Solution518 {

    @Complexity(time = "O(nk)", space = "O(n)", note = "n=amount, k is the number of coins")
    public int change(int amount, int[] coins) {
        // dp[j]: the number of combinations that make up amount j.
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }
}