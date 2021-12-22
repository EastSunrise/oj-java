package cn.wsg.oj.leetcode.problems.p500;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p0.Solution70;
import cn.wsg.oj.leetcode.problems.p1100.Solution1137;

/**
 * 509. Fibonacci Number (EASY)
 *
 * @author Kingen
 * @see Solution70
 * @see Solution842
 * @see Solution873
 * @see Solution1137
 * @see <a href="https://leetcode-cn.com/problems/fibonacci-number/">Fibonacci Number</a>
 */
public class Solution509 implements Solution {

    /**
     * @see #DYNAMIC_PROGRAMMING
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int prev = 0, cur = 1;
        for (int i = 2; i <= n; i++) {
            cur = prev + cur;
            prev = cur - prev;
            cur %= 10_0000_0007;
        }
        return cur;
    }
}
