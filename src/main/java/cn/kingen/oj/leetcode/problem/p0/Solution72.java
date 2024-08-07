package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/edit-distance/">72. Edit Distance</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution161
 * @see cn.kingen.oj.leetcode.problem.p500.Solution583
 * @see cn.kingen.oj.leetcode.problem.p700.Solution712
 * @see cn.kingen.oj.leetcode.problem.p1000.Solution1035
 */
@Question(
        tags = {Tag.STRING, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.MEDIUM
)
public class Solution72 {

    @Complexity(time = "O(m*n)", space = "O(m*n)")
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        // dp[i][j]: the distance of word1[0,i) and word2[0,j)
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) { // word1[0,i) to an empty string
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) { // an empty string to word2[0,j)
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // delete a char or add a char
                dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                } else { // replace a char
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[m][n];
    }
}