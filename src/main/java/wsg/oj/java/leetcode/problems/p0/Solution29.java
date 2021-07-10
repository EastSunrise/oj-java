package wsg.oj.java.leetcode.problems.p0;

import wsg.oj.java.Complexity;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 29. Divide Two Integers (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/divide-two-integers/">Divide Two Integers</a>
 * @since 2021-07-10
 */
class Solution29 implements Solution {

    /**
     * Divides bit by bit.
     *
     * @complexity T(n)=O(b), b=31
     * @see Complexity#SPACE_CONSTANT
     */
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("divided by zero");
        }
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        boolean negative = (dividend ^ divisor) < 0;
        divisor = (divisor >= 0) ? divisor : -divisor;
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            int quotient = dividePositive(-(dividend + divisor), divisor) + 1;
            return negative ? -quotient : quotient;
        }
        dividend = (dividend >= 0) ? dividend : -dividend;
        int quotient = dividePositive(dividend, divisor);
        return negative ? -quotient : quotient;
    }

    private int dividePositive(int dividend, int divisor) {
        // both the dividend and divisor are positive
        int res = 0, mask = 0x4000_0000;
        int tmp = 0;
        while (mask > 0) {
            int top = (dividend & mask) == 0 ? 0 : 1;
            // get the first x bits of the dividend
            tmp = (tmp << 1) | top;
            mask >>= 1;
            // then divide the first x digits by the divisor
            if (tmp >= divisor) {
                // keep the remainder
                tmp -= divisor;
                // add the quotient to the result
                res = (res << 1) | 1;
            } else {
                res = res << 1;
            }
        }
        return res;
    }
}
