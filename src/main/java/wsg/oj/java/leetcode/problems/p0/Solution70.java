package wsg.oj.java.leetcode.problems.p0;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p1100.Solution1137;
import wsg.oj.java.leetcode.problems.p500.Solution509;
import wsg.oj.java.leetcode.problems.p700.Solution746;

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

    int mod = 1_000_000_007;

    /**
     * Fibonacci sequence.
     *
     * @see #DYNAMIC_PROGRAMMING
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int prev = 1, cur = 2;
        for (int i = 3; i <= n; i++) {
            int tmp = (prev + cur) % mod;
            prev = cur;
            cur = tmp;
        }
        return cur;
    }
}
