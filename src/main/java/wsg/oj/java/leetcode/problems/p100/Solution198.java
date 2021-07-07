package wsg.oj.java.leetcode.problems.p100;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p200.Solution213;
import wsg.oj.java.leetcode.problems.p300.Solution337;

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
 * @since 2021-07-04
 */
public class Solution198 extends Solution {

    /**
     * @see #DYNAMIC_PROGRAMMING
     * @see #TIME_N
     * @see #SPACE_N
     */
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        // dp[i]: the maximum amount robbed from nums[0,i]
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[len - 1];
    }
}
