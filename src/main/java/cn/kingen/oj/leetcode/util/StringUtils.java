package cn.kingen.oj.leetcode.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kingen
 **/
public final class StringUtils {

    /**
     * Checks if a character is alphanumeric.
     */
    public static boolean isAlphanumeric(char ch) {
        return (ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }

    /**
     * Checks if a string is a subsequence of another string.
     */
    public static boolean isSubsequence(String seq, String str) {
        int i = seq.length() - 1, j = str.length() - 1;
        while (i >= 0 && j >= i) {
            if (seq.charAt(i) == str.charAt(j)) {
                i--;
            }
            j--;
        }
        return i < 0;
    }

    /**
     * Stats the frequency of characters in a string.
     */
    public static Map<Character, Integer> statFrequency(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char ch : s.toCharArray()) {
            counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        }
        return counts;
    }

    /**
     * Calculates the length of the longest common subsequence of two strings.
     */
    public static int lcs(String s1, String s2) {
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
