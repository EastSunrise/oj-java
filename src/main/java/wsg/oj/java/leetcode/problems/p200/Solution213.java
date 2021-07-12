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
public class Solution213 implements Solution {

    /**
     * @see #DYNAMIC_PROGRAMMING
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // dp[i]: the maximum amount robbed from nums[0,i]
        // dp0: rob nums[0] while nums[len-1] won't be robbed
        // dpn: rob nums[len-1] while nums[0] won't be robbed
        int[] dp0 = new int[len];
        int[] dpn = new int[len];
        dp0[0] = nums[0];
        dp0[1] = Math.max(nums[0], nums[1]);
        dpn[0] = 0;
        dpn[1] = nums[1];
        for (int i = 2; i < len; i++) {
            dp0[i] = Math.max(dp0[i - 1], dp0[i - 2] + nums[i]);
            dpn[i] = Math.max(dpn[i - 1], dpn[i - 2] + nums[i]);
        }
        return Math.max(dp0[len - 2], dpn[len - 1]);
    }
}
