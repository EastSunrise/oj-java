package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p900.Solution989;

/**
 * 66. Plus One (Easy)
 *
 * @author Kingen
 * @see Solution43
 * @see Solution67
 * @see Solution369
 * @see Solution989
 * @see <a href="https://leetcode-cn.com/problems/plus-one/">Plus One</a>
 */
public class Solution66 implements Solution {

    /**
     * Pluses bit by bit with a carry.
     *
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public int[] plusOne(int[] digits) {
        boolean carry = true;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                carry = false;
                break;
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
