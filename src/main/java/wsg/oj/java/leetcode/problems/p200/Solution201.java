package wsg.oj.java.leetcode.problems.p200;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 201. Bitwise AND of Numbers Range (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/">Bitwise AND of
 * Numbers Range</a>
 * @since 2021-07-12
 */
class Solution201 implements Solution {

    /**
     * Changes all bits after consecutive same bits from the first bit to zeros.
     *
     * @complexity T=O(32)
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int rangeBitwiseAnd(int left, int right) {
        // the count of bits after consecutive same bits from the first bit
        int bits = 0;
        while (left > 0 && left != right) {
            left >>>= 1;
            right >>>= 1;
            bits++;
        }
        return left == right ? left << bits : 0;
    }
}
