package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p300.Solution367;

/**
 * 69. Sqrt(x) (Easy)
 *
 * @author Kingen
 * @see Solution50
 * @see Solution367
 * @see <a href="https://leetcode-cn.com/problems/sqrtx/">Sqrt(x)</a>
 */
public class Solution69 implements Solution {

    /**
     * @see #BINARY_SEARCH
     * @see Complexity#TIME_LOG_N
     * @see Complexity#SPACE_CONSTANT
     */
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int left = 1, right = x;
        while (left < right) {
            right = left + (right - left >> 1);
            left = x / right;
        }
        return right;
    }
}
