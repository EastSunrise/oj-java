package wsg.oj.java.leetcode.problems.p0;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 66. Plus One (Easy)
 *
 * @author Kingen
 * @see Solution43
 * @see Solution67
 * @see Solution369
 * @see Solution989
 * @see <a href="https://leetcode-cn.com/problems/plus-one/">Plus One</a>
 * @since 2021-07-11
 */
public class Solution66 implements Solution {

    /**
     * Pluses bit by bit with a carry.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int[] plusOne(int[] digits) {
        boolean carry = true;
        for (int i = digits.length - 1; carry && i >= 0; i--) {
            int d = digits[i] + 1;
            if (d == 10) {
                digits[i] = 0;
            } else {
                digits[i] = d;
                carry = false;
            }
        }
        if (!carry) {
            return digits;
        }
        int[] copy = new int[digits.length + 1];
        copy[0] = 1;
        System.arraycopy(digits, 0, copy, 1, digits.length);
        return copy;
    }
}
