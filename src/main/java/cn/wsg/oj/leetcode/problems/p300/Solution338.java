package cn.wsg.oj.leetcode.problems.p300;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p100.Solution191;

/**
 * 338. Counting Bits (Easy)
 *
 * @author Kingen
 * @see Solution191
 * @see <a href="https://leetcode-cn.com/problems/counting-bits/">Counting Bits</a>
 */
public class Solution338 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public int[] countBits(int n) {
        int[] counts = new int[n + 1];
        int start = 1;
        while (start <= n) {
            int maxLen = start;
            counts[start++] = 1;
            for (int len = 1; len < maxLen; len *= 2) {
                for (int i = 0; i < len; i++) {
                    if (start > n) {
                        return counts;
                    }
                    counts[start] = counts[start - len] + 1;
                    start++;
                }
            }
        }
        return counts;
    }

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public int[] countBits2(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }
}
