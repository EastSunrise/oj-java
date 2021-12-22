package cn.wsg.oj.leetcode.problems.p100;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p200.Solution213;
import cn.wsg.oj.leetcode.problems.p300.Solution337;
import cn.wsg.oj.leetcode.problems.p700.Solution740;

/**
 * 198. House Robber (Medium)
 *
 * @author Kingen
 * @see Solution152
 * @see Solution213
 * @see Solution256
 * @see Solution276
 * @see Solution337
 * @see Solution600
 * @see Solution656
 * @see Solution740
 * @see <a href="https://leetcode-cn.com/problems/house-robber/">House Robber</a>
 */
public class Solution198 implements Solution {

    /**
     * @see #DYNAMIC_PROGRAMMING
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public int rob(int[] nums) {
        return rob(nums, 0, nums.length - 1);
    }

    protected int rob(int[] nums, int fromIn, int toIn) {
        if (fromIn == toIn) {
            return nums[fromIn];
        }
        int prev = 0, cur = nums[fromIn], next;
        for (int i = fromIn + 1; i <= toIn; i++) {
            next = Math.max(prev + nums[i], cur);
            prev = cur;
            cur = next;
        }
        return cur;
    }
}
