package wsg.oj.java.leetcode.problems.p0;

import wsg.oj.java.algorithm.regex.RegularExp;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 10. Regular Expression Matching (HARD)
 *
 * @author Kingen
 * @see Solution44
 * @see <a href="https://leetcode-cn.com/problems/regular-expression-matching/">Regular Expression
 * Matching</a>
 * @since 2021-07-16
 */
class Solution10 implements Solution {

    /**
     * @see #DYNAMIC_PROGRAMMING
     * @see wsg.oj.java.Complexity#TIME_MN
     * @see wsg.oj.java.Complexity#SPACE_MN
     */
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        // dp[i][j]: whether s[0,i) matches p[0,j)
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2] || (matches(s, p, i, j - 2) && dp[i - 1][j]);
                } else {
                    dp[i][j] = matches(s, p, i, j - 1) && dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    private boolean matches(String s, String p, int i, int j) {
        return i > 0 && (p.charAt(j) == '.' || s.charAt(i - 1) == p.charAt(j));
    }

    public boolean isMatch2(String s, String p) {
        return RegularExp.compile(p).matches(s);
    }
}
