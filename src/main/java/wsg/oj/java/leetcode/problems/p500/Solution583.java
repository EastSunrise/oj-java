package wsg.oj.java.leetcode.problems.p500;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p0.Solution72;
import wsg.oj.java.leetcode.problems.p1100.Solution1143;
import wsg.oj.java.leetcode.problems.p700.Solution712;

/**
 * 583. Delete Operation for Two Strings (MEDIUM)
 *
 * @author Kingen
 * @see Solution72
 * @see Solution712
 * @see Solution1143
 * @see <a href="https://leetcode-cn.com/problems/delete-operation-for-two-strings/">Delete
 * Operation for Two Strings</a>
 * @since 2021-07-20
 */
public class Solution583 implements Solution {

    /**
     * Calculates the longest common subsequence of the two words.
     *
     * @see #DYNAMIC_PROGRAMMING
     * @see wsg.oj.java.Complexity#TIME_MN
     * @see wsg.oj.java.Complexity#SPACE_MN
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        // dp[i][j]: the longest common subsequence of word1[0,i-1] and word2[0,j-1]
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                }
            }
        }
        return m + n - 2 * dp[m][n];
    }
}
