package wsg.oj.java.leetcode.problems.p0;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 87. Scramble String (HARD)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/scramble-string/">Scramble String</a>
 * @since 2021-07-19
 */
class Solution87 implements Solution {

    /**
     * @complexity T=O(n^4)
     * @complexity S=O(n^3)
     */
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        int[] counts = new int[26];
        for (char ch : s1.toCharArray()) {
            counts[ch - 'a']++;
        }
        for (char ch : s2.toCharArray()) {
            counts[ch - 'a']--;
            if (counts[ch - 'a'] < 0) {
                return false;
            }
        }
        int len = s1.length();
        // dp[i][j][k]: whether s1[i,i+k) and s2[j,j+k) are scramble
        // -1: false, 0: unknown, 1: true
        int[][][] dp = new int[len][len][len + 1];
        return isScramble(dp, s1.toCharArray(), 0, s2.toCharArray(), 0, len);
    }

    boolean isScramble(int[][][] dp, char[] s1, int from1, char[] s2, int from2, int len) {
        // checked before
        if (dp[from1][from2][len] != 0) {
            return dp[from1][from2][len] > 0;
        }
        if (len == 1) {
            if (s1[from1] == s2[from2]) {
                dp[from1][from2][len] = 1;
                return true;
            } else {
                dp[from1][from2][len] = -1;
                return false;
            }
        }
        for (int k = 1; k < len; k++) {
            // s1=x1+y1, s2=x2+y2
            // check x1 and x2, y1 and y2
            if (isScramble(dp, s1, from1, s2, from2, k)
                && isScramble(dp, s1, from1 + k, s2, from2 + k, len - k)) {
                return true;
            }
            // check x1 and y2, x2 and y1
            if (isScramble(dp, s1, from1, s2, from2 + len - k, k)
                && isScramble(dp, s1, from1 + k, s2, from2, len - k)) {
                return true;
            }
        }
        dp[from1][from2][len] = -1;
        return false;
    }
}
