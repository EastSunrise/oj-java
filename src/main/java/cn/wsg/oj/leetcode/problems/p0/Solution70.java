package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p1100.Solution1137;
import cn.wsg.oj.leetcode.problems.p500.Solution509;
import cn.wsg.oj.leetcode.problems.p700.Solution746;

/**
 * 70. Climbing Stairs (Easy)
 *
 * @author Kingen
 * @see Solution746
 * @see Solution509
 * @see Solution1137
 * @see <a href="https://leetcode-cn.com/problems/climbing-stairs/">Climbing Stairs</a>
 */
public class Solution70 implements Solution {

    /**
     * Fibonacci sequence.
     *
     * @see #DYNAMIC_PROGRAMMING
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int prev = 1, cur = 2;
        for (int i = 3; i <= n; i++) {
            int tmp = (prev + cur) % MOD;
            prev = cur;
            cur = tmp;
        }
        return cur;
    }
}
