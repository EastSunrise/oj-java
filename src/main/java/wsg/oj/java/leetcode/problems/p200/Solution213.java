package wsg.oj.java.leetcode.problems.p200;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p100.Solution198;
import wsg.oj.java.leetcode.problems.p300.Solution337;

/**
 * 213. House Robber II (Medium)
 *
 * @author Kingen
 * @see Solution198
 * @see Solution256
 * @see Solution276
 * @see Solution337
 * @see Solution600
 * @see Solution656
 * @see <a href="https://leetcode-cn.com/problems/house-robber-ii/">House Robber II</a>
 * @since 2021-07-04
 */
public class Solution213 extends Solution198 implements Solution {

    /**
     * @see #DYNAMIC_PROGRAMMING
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    @Override
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
    }
}
