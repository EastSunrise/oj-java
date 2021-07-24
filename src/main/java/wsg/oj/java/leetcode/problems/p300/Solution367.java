package wsg.oj.java.leetcode.problems.p300;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p0.Solution69;
import wsg.oj.java.leetcode.problems.p600.Solution633;

/**
 * 367. Valid Perfect Square (Easy)
 *
 * @author Kingen
 * @see Solution69
 * @see Solution633
 * @see <a href="https://leetcode-cn.com/problems/valid-perfect-square/">Valid Perfect Square</a>
 * @since 2021-07-13
 */
public class Solution367 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_LOG_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public boolean isPerfectSquare(int num) {
        int left = 1, right = num;
        while (left < right) {
            right = (left + right) >> 1;
            left = num / right;
        }
        return right * right == num;
    }
}
