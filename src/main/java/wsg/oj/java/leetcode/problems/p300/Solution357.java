package wsg.oj.java.leetcode.problems.p300;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 357. Count Numbers with Unique Digits (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/count-numbers-with-unique-digits/">Count Numbers
 * with Unique Digits</a>
 * @since 2021-07-04
 */
class Solution357 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int countNumbersWithUniqueDigits(int n) {
        int res = 1, factorial = 1, k = 9;
        for (int i = 1; i <= n; i++) {
            res += 9 * factorial;
            factorial *= k--;
        }
        return res;
    }
}
