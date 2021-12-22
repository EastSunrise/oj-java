package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p100.Solution190;

/**
 * 7. Reverse Integer (Easy)
 *
 * @author Kingen
 * @see Solution8
 * @see Solution190
 * @see <a href="https://leetcode-cn.com/problems/reverse-integer/">Reverse Integer</a>
 */
public class Solution7 implements Solution {

    /**
     * Handles as a negative number and compares with the two limits when adding the next digit in
     * case that the value goes outside the signed 32-bit integer range.
     *
     * @complexity T=O(d), d=the number of digits of x
     * @see Complexity#SPACE_CONSTANT
     */
    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        boolean positive = x > 0;
        int limit = positive ? -Integer.MAX_VALUE : Integer.MIN_VALUE;
        int mulLimit = limit / 10;
        int res = 0, tmp = positive ? -x : x;
        // handle as negative
        while (tmp < 0) {
            int digit = tmp % 10;
            if (res < mulLimit) {
                // exceed
                return 0;
            }
            res *= 10;
            if (res < limit - digit) {
                // exceed
                return 0;
            }
            res += digit;
            tmp /= 10;
        }
        return positive ? -res : res;
    }
}
