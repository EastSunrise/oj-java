package cn.kingen.oj.leetcode.problem.p1200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/palindrome-partitioning-iii/">1278. Palindrome Partitioning III</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1700.Solution1745
 * @see cn.kingen.oj.leetcode.problem.p2400.Solution2472
 * @see cn.kingen.oj.leetcode.problem.p2900.Solution2911

 */
@Question(
        tags = {Tag.STRING, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.HARD,
        date = "2025-03-03"
)
public class Solution1278 {

    @Complexity(time = "O(n^3)", space = "O(n^2)")
    public int palindromePartition(String s, int k) {
        int n = s.length();
        // dp[i][j] is the minimum number of changes to make s[i,j-1] a palindrome
        int[][] dp = new int[n][n + 1];
        for (int i = 0; i < n; i++) {
            dp[i][i] = dp[i][i + 1] = 0;
        }
        char[] chars = s.toCharArray();
        for (int l = 2; l <= n; l++) {
            for (int i = n - l, j = n; i >= 0; i--, j--) {
                dp[i][j] = dp[i + 1][j - 1] + (chars[i] == chars[j - 1] ? 0 : 1);
            }
        }

        // fp[i][t] is the minimum number of changes to partition s[0,i-1] to t palindrome parts
        int[][] fp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            fp[i][1] = dp[0][i];
            for (int t = 2, tm = Math.min(i, k); t <= tm; t++) {
                int min = Integer.MAX_VALUE;
                for (int j = t - 1; j < i; j++) {
                    min = Math.min(min, fp[j][t - 1] + dp[j][i]);
                }
                fp[i][t] = min;
            }
        }
        return fp[n][k];
    }
}