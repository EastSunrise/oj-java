package wsg.oj.java.leetcode.problems.p100;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 191. Number of 1 Bits (Easy)
 *
 * @author Kingen
 * @see Solution190
 * @see Solution231
 * @see Solution338
 * @see Solution401
 * @see Solution461
 * @see Solution693
 * @see Solution762
 * @see <a href="https://leetcode-cn.com/problems/number-of-1-bits/">Number of 1 Bits</a>
 * @since 2021-07-12
 */
class Solution191 implements Solution {

    /**
     * @complexity T=O(32)
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int hammingWeight(int n) {
        int weight = 0;
        for (int i = 0; i < 32; i++) {
            weight += n & 1;
            n >>= 1;
        }
        return weight;
    }
}
