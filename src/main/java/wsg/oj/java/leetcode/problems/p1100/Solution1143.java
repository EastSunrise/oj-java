package wsg.oj.java.leetcode.problems.p1100;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p500.Solution516;
import wsg.oj.java.leetcode.problems.p500.Solution583;

/**
 * 1143. Longest Common Subsequence (MEDIUM)
 *
 * @author Kingen
 * @see Solution516
 * @see Solution583
 * @see Solution1092
 * @see <a href="https://leetcode-cn.com/problems/longest-common-subsequence/">Longest Common
 * Subsequence</a>
 * @since 2021-07-27
 */
public class Solution1143 implements Solution {

    /**
     * @see #DYNAMIC_PROGRAMMING
     * @see wsg.oj.java.Complexity#TIME_MN
     * @see wsg.oj.java.Complexity#SPACE_MN
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        // dp[i][j]: the length of the lcs of text1[0,i-1] and text2[0,j-1]
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
