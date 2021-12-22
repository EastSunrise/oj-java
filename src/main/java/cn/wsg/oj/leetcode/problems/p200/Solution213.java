package cn.wsg.oj.leetcode.problems.p200;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p100.Solution198;
import cn.wsg.oj.leetcode.problems.p300.Solution337;

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
 */
public class Solution213 extends Solution198 implements Solution {

    /**
     * @see #DYNAMIC_PROGRAMMING
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
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
