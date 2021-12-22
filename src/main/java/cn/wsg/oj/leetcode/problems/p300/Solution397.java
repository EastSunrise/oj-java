package cn.wsg.oj.leetcode.problems.p300;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 397. Integer Replacement (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/integer-replacement/">Integer Replacement</a>
 */
class Solution397 implements Solution {

    /**
     * Thinks of the last two bits of the number.
     *
     * @see Complexity#TIME_LOG_N
     * @see Complexity#SPACE_LOG_N
     */
    public int integerReplacement(int n) {
        if (n < 4) {
            return n - 1;
        }
        int i = n & 3;
        if (i == 0) {
            return integerReplacement(n >>> 2) + 2;
        }
        if (i == 1) {
            return integerReplacement(n >>> 2) + 3;
        }
        if (i == 2) {
            return integerReplacement(n >>> 1) + 1;
        }
        return integerReplacement((n >>> 2) + 1) + 3;
    }
}
