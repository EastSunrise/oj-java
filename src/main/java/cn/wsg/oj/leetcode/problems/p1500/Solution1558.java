package cn.wsg.oj.leetcode.problems.p1500;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 1558. Minimum Numbers of Function Calls to Make Target Array (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/minimum-numbers-of-function-calls-to-make-target-array/">Minimum
 * Numbers of Function Calls to Make Target Array</a>
 */
public class Solution1558 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
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
