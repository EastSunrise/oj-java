package cn.wsg.oj.leetcode.problems.p100;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.Arrays;

/**
 * 115. Distinct Subsequences (HARD)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/distinct-subsequences/">Distinct Subsequences</a>
 */
class Solution115 implements Solution {

    /**
     * @see #DYNAMIC_PROGRAMMING
     * @see Complexity#TIME_MN
     * @see Complexity#SPACE_MN
     */
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n || n == 0) {
            return 0;
        }
        // dp[i][j]: the number between s[0,i) and t[0,j)
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= m; i++) {
            // pass if j > i
            for (int j = 1; j <= i && j <= n; j++) {
                // t[0,j) in s[0,i-1) ignoring s[i]
                dp[i][j] = dp[i - 1][j];
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // use s[i] to match t[j]
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    /**
     * @see Complexity#TIME_MN
     * @see Complexity#SPACE_MN
     */
    public int numDistinct2(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n || n == 0) {
            return 0;
        }
        int[][] dp = new int[m][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return matches(dp, s, 0, t, 0);
    }

    private int matches(int[][] dp, String s, int i, String t, int j) {
        if (j == t.length()) {
            return 1;
        }
        if (dp[i][j] >= 0) {
            return dp[i][j];
        }
        char target = t.charAt(j);
        int count = 0;
        for (int k = i, max = s.length() - t.length() + j; k <= max; k++) {
            if (s.charAt(k) == target) {
                count += matches(dp, s, k + 1, t, j + 1);
            }
        }
        dp[i][j] = count;
        return count;
    }
}
