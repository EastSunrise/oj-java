package wsg.oj.java.leetcode.problems.p1500;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 1558. Minimum Numbers of Function Calls to Make Target Array (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/minimum-numbers-of-function-calls-to-make-target-array/">Minimum
 * Numbers of Function Calls to Make Target Array</a>
 * @since 2021-07-27
 */
public class Solution1558 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int minOperations(int[] nums) {
        int op0 = 0, max = 0;
        for (int num : nums) {
            op0 += Integer.bitCount(num);
            max = Math.max(max, num);
        }
        while (max > 1) {
            op0++;
            max >>= 1;
        }
        return op0;
    }
}
