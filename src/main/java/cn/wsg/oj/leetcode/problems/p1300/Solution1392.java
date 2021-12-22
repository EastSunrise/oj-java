package cn.wsg.oj.leetcode.problems.p1300;

import cn.wsg.oj.algorithm.BmSearching;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 1392. Longest Happy Prefix (HARD)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/longest-happy-prefix/">Longest Happy Prefix</a>
 */
public class Solution1392 implements Solution {

    /**
     * @see BmSearching
     */
    public String longestPrefix(String s) {
        int n = s.length();
        int i = 0, k = -1;
        int[] dp = new int[n];
        dp[0] = -1;
        while (i < n - 1) {
            if (k == -1 || s.charAt(i) == s.charAt(k)) {
                k++;
                i++;
                dp[i] = k;
            } else {
                k = dp[k];
            }
        }
        return dp[n - 1] == -1 ? "" : s.substring(dp[n - 1]);
    }
}
