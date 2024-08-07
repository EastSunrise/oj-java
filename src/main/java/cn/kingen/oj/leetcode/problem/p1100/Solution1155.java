package cn.kingen.oj.leetcode.problem.p1100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import static cn.kingen.oj.leetcode.util.MathUtils.MOD;

/**
 * <a href="https://leetcode.cn/problems/number-of-dice-rolls-with-target-sum/">1155. Number of Dice Rolls With Target Sum</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1700.Solution1775
 * @see cn.kingen.oj.leetcode.problem.p2000.Solution2028
 */
@Question(
        tags = {Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.MEDIUM
)
public class Solution1155 {

    @Complexity(time = "O(n*k*target)", space = "O(n*target)")
    public int numRollsToTarget(int n, int k, int target) {
        // dp[i][s]: the number of possible ways to roll i-dices and get sum s
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int max = Math.min(target, i * k); // the maximum sum of i-dices
            for (int j = 1; j <= k; j++) { // the number of i-th dice
                for (int s = i - 1 + j; s <= max; s++) {
                    dp[i][s] = (dp[i][s] + dp[i - 1][s - j]) % MOD;
                }
            }
        }
        return dp[n][target];
    }
}