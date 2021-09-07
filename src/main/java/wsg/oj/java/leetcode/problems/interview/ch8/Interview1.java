package wsg.oj.java.leetcode.problems.interview.ch8;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 面试题 8.1. Three Steps Problem LCCI (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/three-steps-problem-lcci/">Three Steps Problem
 * LCCI</a>
 * @since 2021-07-28
 */
public class Interview1 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int waysToStep(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        if (n > 1) {
            dp[1] = 2;
            if (n > 2) {
                dp[2] = 4;
            }
        }
        for (int i = 3; i < n; i++) {
            dp[i] = ((dp[i - 1] + dp[i - 2]) % MOD + dp[i - 3]) % MOD;
        }
        return dp[n - 1];
    }
}
