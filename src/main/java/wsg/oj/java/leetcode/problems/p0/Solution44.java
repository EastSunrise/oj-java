package wsg.oj.java.leetcode.problems.p0;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 44. Wildcard Matching (HARD)
 *
 * @author Kingen
 * @see Solution10
 * @see <a href="https://leetcode-cn.com/problems/wildcard-matching/">Wildcard Matching</a>
 * @since 2021-07-18
 */
public class Solution44 implements Solution {

    /**
     * @see #DYNAMIC_PROGRAMMING
     * @see wsg.oj.java.Complexity#TIME_MN
     * @see wsg.oj.java.Complexity#SPACE_MN
     */
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        // dp[i][j]: whether s[0,i) and p[0,j) are matched
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int j = 1; j <= n; j++) {
            // '*' matches any string
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            } else {
                break;
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char ch = p.charAt(j - 1);
                if (ch == '*') {
                    // '*' matches '' or any string
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else {
                    dp[i][j] = (ch == '?' || ch == s.charAt(i - 1)) && dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
