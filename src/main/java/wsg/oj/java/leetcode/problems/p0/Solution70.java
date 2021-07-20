package wsg.oj.java.leetcode.problems.p0;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p500.Solution509;

/**
 * 70. Climbing Stairs (Easy)
 *
 * @author Kingen
 * @see Solution746
 * @see Solution509
 * @see Solution1137
 * @see <a href="https://leetcode-cn.com/problems/climbing-stairs/">Climbing Stairs</a>
 * @since 2021-07-11
 */
public class Solution70 implements Solution {

    /**
     * Fibonacci sequence.
     *
     * @see #DYNAMIC_PROGRAMMING
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int lastLast = 1, last = 2;
        for (int i = 3; i <= n; i++) {
            last = lastLast + last;
            lastLast = last - lastLast;
        }
        return last;
    }
}
