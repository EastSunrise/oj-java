package cn.wsg.oj.leetcode.problems.p1100;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p1700.Solution1775;

/**
 * 1155. Number of Dice Rolls With Target Sum (MEDIUM)
 *
 * @author Kingen
 * @see Solution1775
 * @see <a href="https://leetcode-cn.com/problems/number-of-dice-rolls-with-target-sum/">Number of
 * Dice Rolls With Target Sum</a>
 */
public class Solution1155 implements Solution {

    /**
     * @complexity T=O(d*f*K), K=target
     * @complexity S=O(d*K)
     */
    public int numRollsToTarget(int d, int f, int target) {
        // dp[i][j]: the number of possible ways to roll (i+1) dice up to j
        int[][] dp = new int[d][target + 1];
        for (int k = 1; k <= f && k <= target; k++) {
            dp[0][k] = 1;
        }
        for (int i = 1; i < d; i++) {
            for (int j = 1; j <= f; j++) {
                int max = Math.min(target, (i + 1) * f);
                for (int k = (i + j); k <= max; k++) {
                    dp[i][k] = (dp[i][k] + dp[i - 1][k - j]) % MOD;
                }
            }
        }
        return dp[d - 1][target];
    }
}
