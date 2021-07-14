package wsg.oj.java.leetcode.problems.p400;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 485. Max Consecutive Ones (Easy)
 *
 * @author Kingen
 * @see Solution487
 * @see Solution1004
 * @see Solution1446
 * @see Solution1869
 * @see <a href="https://leetcode-cn.com/problems/max-consecutive-ones/">Max Consecutive Ones</a>
 * @since 2021-07-14
 */
class Solution485 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, max = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                max = Math.max(count, max);
                count = 0;
            }
        }
        return Math.max(count, max);
    }
}
