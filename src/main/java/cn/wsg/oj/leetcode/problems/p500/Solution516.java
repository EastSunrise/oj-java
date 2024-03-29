package cn.wsg.oj.leetcode.problems.p500;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p0.Solution5;
import cn.wsg.oj.leetcode.problems.p1100.Solution1143;
import cn.wsg.oj.leetcode.problems.p600.Solution647;

/**
 * 516. Longest Palindromic Subsequence (MEDIUM)
 *
 * @author Kingen
 * @see Solution5
 * @see Solution647
 * @see Solution730
 * @see Solution1143
 * @see Solution1682
 * @see Solution1771
 * @see <a href="https://leetcode-cn.com/problems/longest-palindromic-subsequence/">Longest
 * Palindromic Subsequence</a>
 */
public class Solution516 implements Solution {

    /**
     * @see #DYNAMIC_PROGRAMMING
     * @see Complexity#TIME_NN
     * @see Complexity#SPACE_NN
     */
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        // dp[i][j]: the longest palindrome of s[i,j]
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    // axxxa
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    // axxxb
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
