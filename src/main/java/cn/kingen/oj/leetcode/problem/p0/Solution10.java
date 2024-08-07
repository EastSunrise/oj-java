package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/regular-expression-matching/">10. Regular Expression Matching</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution44
 */
@Question(
        tags = {Tag.RECURSION, Tag.STRING, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.HARD
)
public class Solution10 {

    @Complexity(time = "O(m*n)", space = "O(m*n)")
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        // dp[i][j]: whether s[0,i) matches p[0,j)
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char ch = p.charAt(j - 1);
                if (ch == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (ch == '*') {
                    dp[i][j] = dp[i][j - 2];
                    char x = p.charAt(j - 2);
                    if (x == '.' || x == s.charAt(i - 1)) {
                        dp[i][j] |= dp[i - 1][j];
                    }
                } else {
                    dp[i][j] = ch == s.charAt(i - 1) && dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}