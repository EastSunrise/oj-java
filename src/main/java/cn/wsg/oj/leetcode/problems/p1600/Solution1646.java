package cn.wsg.oj.leetcode.problems.p1600;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 1646. Get Maximum in Generated Array (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/get-maximum-in-generated-array/">Get Maximum in
 * Generated Array</a>
 */
public class Solution1646 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public int getMaximumGenerated(int n) {
        if (n < 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        int max = 1;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i / 2];
            } else {
                dp[i] = dp[i / 2] + dp[i / 2 + 1];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
