package cn.kingen.oj.leetcode.problem.p400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/ones-and-zeroes/">474. Ones and Zeroes</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p600.Solution600
 */
@Question(
        tags = {Tag.ARRAY, Tag.STRING, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.MEDIUM
)
public class Solution474 {

    @Complexity(time = "O(k*(m*n+L))", space = "O(m*n)", note = "k is the number of strings, L is the average length of strings")
    public int findMaxForm(String[] strs, int m, int n) {
        // dp[i][j]: the size of the largest subset of strs[0,k] with at most i 0s and j 1s.
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int zeros = 0, ones = 0;
            for (int i = 0, len = str.length(); i < len; i++) {
                if (str.charAt(i) == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }
            // traverse in reverse order to compare with the dp result of strs[0,k-1]
            // instead of ones just updated
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }
}