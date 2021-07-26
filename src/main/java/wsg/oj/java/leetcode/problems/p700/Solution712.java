package wsg.oj.java.leetcode.problems.p700;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p0.Solution72;
import wsg.oj.java.leetcode.problems.p300.Solution300;
import wsg.oj.java.leetcode.problems.p500.Solution583;

/**
 * 712. Minimum ASCII Delete Sum for Two Strings (MEDIUM)
 *
 * @author Kingen
 * @see Solution72
 * @see Solution300
 * @see Solution583
 * @see <a href="https://leetcode-cn.com/problems/minimum-ascii-delete-sum-for-two-strings/">Minimum
 * ASCII Delete Sum for Two Strings</a>
 * @since 2021-07-26
 */
public class Solution712 implements Solution {

    /**
     * @see #DYNAMIC_PROGRAMMING
     * @see wsg.oj.java.Complexity#TIME_MN
     * @see wsg.oj.java.Complexity#SPACE_MN
     */
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        // dp[i][j]: the sum between s1[0,i-1] and s2[0,j-1]
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = s1.charAt(i - 1) + dp[i - 1][0];
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = s2.charAt(j - 1) + dp[0][j - 1];
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math
                        .min(dp[i - 1][j] + s1.charAt(i - 1), dp[i][j - 1] + s2.charAt(j - 1));
                }
            }
        }
        return dp[m][n];
    }
}
