package cn.kingen.oj.leetcode.problem.p300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/coin-change/">322. Coin Change</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p900.Solution983
 * @see cn.kingen.oj.leetcode.problem.p2200.Solution2218
 * @see cn.kingen.oj.leetcode.problem.p2200.Solution2224
 * @see cn.kingen.oj.leetcode.problem.p2500.Solution2547
 * @see cn.kingen.oj.leetcode.problem.p2900.Solution2902
 * @see cn.kingen.oj.leetcode.problem.p2900.Solution2915
 * @see cn.kingen.oj.leetcode.problem.p2900.Solution2952
 * @see cn.kingen.oj.leetcode.problem.p2900.Solution2979
 */
@Question(
        tags = {Tag.BREADTH_FIRST_SEARCH, Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.MEDIUM
)
public class Solution322 {

    @Complexity(time = "O(nk)", space = "O(n)", note = "k is the number of coins")
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }
}