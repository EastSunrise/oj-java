package wsg.oj.java.leetcode.problems.p300;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 397. Integer Replacement (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/integer-replacement/">Integer Replacement</a>
 * @since 2021-07-06
 */
class Solution397 implements Solution {

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
