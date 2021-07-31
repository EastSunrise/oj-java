package wsg.oj.java.leetcode.problems.p800;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 868. Binary Gap (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/binary-gap/">Binary Gap</a>
 * @since 2021-07-27
 */
public class Solution868 implements Solution {

    /**
     * @complexity T=O(32)
     * @complexity S=O(1)
     */
    public int binaryGap(int n) {
        // the last 1
        while (n > 0 && (n & 1) == 0) {
            n >>= 1;
        }
        n >>= 1;
        int max = 0, dist = 0;
        while (n > 0) {
            dist++;
            // when one appears
            if ((n & 1) == 1) {
                max = Math.max(max, dist);
                dist = 0;
            }
            n >>= 1;
        }
        return max;
    }
}
