package wsg.oj.java.leetcode.problems.base;

import java.util.HashMap;
import java.util.Map;

/**
 * Common methods of String operations.
 *
 * @author Kingen
 * @since 2021/8/16
 */
public interface StringSolution extends Solution {

    /**
     * Stats the frequency of characters in a string.
     */
    default Map<Character, Integer> stat(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char ch : s.toCharArray()) {
            counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        }
        return counts;
    }

    /**
     * The longest common subsequence of two strings.
     *
     * @see #DYNAMIC_PROGRAMMING
     * @see wsg.oj.java.Complexity#TIME_MN
     * @see wsg.oj.java.Complexity#SPACE_MN
     */
    default int lcs(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        // dp[i][j]: the length of the lcs of s1[0,i-1] and s2[0,j-1]
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
