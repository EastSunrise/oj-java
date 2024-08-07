package cn.kingen.oj.leetcode.problem.p700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/minimum-ascii-delete-sum-for-two-strings/">712. Minimum ASCII Delete Sum for Two Strings</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution72
 * @see cn.kingen.oj.leetcode.problem.p300.Solution300
 * @see cn.kingen.oj.leetcode.problem.p500.Solution583
 */
@Question(
        tags = {Tag.STRING, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.MEDIUM
)
public class Solution712 {

    @Complexity(time = "O(m*n)", space = "O(m*n)")
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
                    dp[i][j] = Math.min(dp[i - 1][j] + s1.charAt(i - 1), dp[i][j - 1] + s2.charAt(j - 1));
                }
            }
        }
        return dp[m][n];
    }
}