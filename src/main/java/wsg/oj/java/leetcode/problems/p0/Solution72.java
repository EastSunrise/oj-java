package wsg.oj.java.leetcode.problems.p0;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p1000.Solution1035;
import wsg.oj.java.leetcode.problems.p500.Solution583;
import wsg.oj.java.leetcode.problems.p700.Solution712;

/**
 * 72. Edit Distance (HARD)
 *
 * @author Kingen
 * @see Solution161
 * @see Solution583
 * @see Solution712
 * @see Solution1035
 * @see <a href="https://leetcode-cn.com/problems/edit-distance/">Edit Distance</a>
 * @since 2021-07-19
 */
public class Solution72 implements Solution {

    /**
     * @see #DYNAMIC_PROGRAMMING
     * @see wsg.oj.java.Complexity#TIME_MN
     * @see wsg.oj.java.Complexity#SPACE_MN
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        // dp[i][j]: the distance of word1[0,i) and word2[0,j)
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            // word1[0,i) to an empty string
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            // an empty string to word2[0,j)
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // delete a char or add a char
                dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                } else {
                    // replace a char
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
