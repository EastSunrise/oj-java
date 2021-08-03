package wsg.oj.java.leetcode.problems.p0;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 97. Interleaving String (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/interleaving-string/">Interleaving String</a>
 * @since 2021-07-11
 */
class Solution97 implements Solution {

    /**
     * @see #DYNAMIC_PROGRAMMING
     * @see wsg.oj.java.Complexity#TIME_MN
     * @see wsg.oj.java.Complexity#SPACE_MN
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if (m + n != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char ch3 = s3.charAt(i + j - 1);
                dp[i][j] = (s1.charAt(i - 1) == ch3 && dp[i - 1][j])
                    || (s2.charAt(j - 1) == ch3 && dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }
}
