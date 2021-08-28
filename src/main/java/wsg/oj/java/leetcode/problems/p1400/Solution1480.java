package wsg.oj.java.leetcode.problems.p1400;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 1480. Running Sum of 1d Array (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/running-sum-of-1d-array/">Running Sum of 1d
 * Array</a>
 * @since 2021-07-27
 */
public class Solution1480 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            nums[i] = nums[i - 1] + nums[i];
        }
        return nums;
    }
}
