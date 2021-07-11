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
     * @see wsg.oj.java.Complexity#SPACE_M_PLUS_N
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 + len2 != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int j = 1; j <= len2; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                char ch3 = s3.charAt(i + j - 1);
                dp[i][j] = (s1.charAt(i - 1) == ch3 && dp[i - 1][j])
                    || (s2.charAt(j - 1) == ch3 && dp[i][j - 1]);
            }
        }
        return dp[len1][len2];
    }
}
