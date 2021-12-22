package cn.wsg.oj.leetcode.problems.p300;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p0.Solution69;
import cn.wsg.oj.leetcode.problems.p600.Solution633;

/**
 * 367. Valid Perfect Square (Easy)
 *
 * @author Kingen
 * @see Solution69
 * @see Solution633
 * @see <a href="https://leetcode-cn.com/problems/valid-perfect-square/">Valid Perfect Square</a>
 */
public class Solution367 implements Solution {

    /**
     * @see Complexity#TIME_LOG_N
     * @see Complexity#SPACE_CONSTANT
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
