package wsg.oj.java.leetcode.problems.p300;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p100.Solution191;

/**
 * 338. Counting Bits (Easy)
 *
 * @author Kingen
 * @see Solution191
 * @see <a href="https://leetcode-cn.com/problems/counting-bits/">Counting Bits</a>
 * @since 2021-07-13
 */
class Solution338 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
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
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int[] countBits2(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }
}
