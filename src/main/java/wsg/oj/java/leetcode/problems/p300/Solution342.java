package wsg.oj.java.leetcode.problems.p300;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p200.Solution231;

/**
 * 342. Power of Four (Easy)
 *
 * @author Kingen
 * @see Solution231
 * @see Solution326
 * @see <a href="https://leetcode-cn.com/problems/power-of-four/">Power of Four</a>
 * @since 2021-07-13
 */
public class Solution342 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_CONSTANT
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public boolean isPowerOfFour(int n) {
        // even not power of 2
        if (n < 1 || (n & (n - 1)) != 0) {
            return false;
        }
        // a power of 2 can be represented as (3-1)^n = 3k + (-1)^n
        return n % 3 == 1;
    }
}
