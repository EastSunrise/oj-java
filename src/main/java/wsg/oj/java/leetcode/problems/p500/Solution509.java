package wsg.oj.java.leetcode.problems.p500;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p0.Solution70;

/**
 * 509. Fibonacci Number (EASY)
 *
 * @author Kingen
 * @see Solution70
 * @see Solution842
 * @see Solution873
 * @see Solution1137
 * @see <a href="https://leetcode-cn.com/problems/fibonacci-number/">Fibonacci Number</a>
 * @since 2021-07-20
 */
public class Solution509 implements Solution {

    /**
     * @see #DYNAMIC_PROGRAMMING
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            nums[i] = nums[i - 2] + nums[i - 1];
        }
        return nums[n];
    }
}
