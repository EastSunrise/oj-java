package wsg.oj.java.leetcode.problems.p0;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 69. Sqrt(x) (Easy)
 *
 * @author Kingen
 * @see Solution50
 * @see Solution367
 * @see <a href="https://leetcode-cn.com/problems/sqrtx/">Sqrt(x)</a>
 * @since 2021-07-11
 */
public class Solution69 implements Solution {

    /**
     * @see #BINARY_SEARCH
     * @see wsg.oj.java.Complexity#TIME_LOG_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int left = 1, right = x;
        while (left < right) {
            right = left + ((right - left) >> 1);
            left = x / right;
        }
        return right;
    }
}
