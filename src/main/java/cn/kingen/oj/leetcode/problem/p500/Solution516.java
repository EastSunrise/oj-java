package cn.kingen.oj.leetcode.problem.p500;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/longest-palindromic-subsequence/">516. Longest Palindromic Subsequence</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution5
 * @see cn.kingen.oj.leetcode.problem.p600.Solution647
 * @see cn.kingen.oj.leetcode.problem.p700.Solution730
 */
@Question(
        tags = {Tag.STRING, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.MEDIUM
)
public class Solution516 {

    @Complexity(time = "O(n^2)", space = "O(n^2)")
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        // dp[l][i]: the longest palindrome of s[i,i+l)
        int[][] dp = new int[n + 1][n];
        for (int i = 0; i < n; i++) {
            dp[1][i] = 1;
        }
        for (int l = 2; l <= n; l++) {
            for (int i = n - l; i >= 0; i--) {
                if (s.charAt(i) == s.charAt(i + l - 1)) {
                    dp[l][i] = dp[l - 2][i + 1] + 2;
                } else {
                    dp[l][i] = Math.max(dp[l - 1][i], dp[l - 1][i + 1]);
                }
            }
        }
        return dp[n][0];
    }
}