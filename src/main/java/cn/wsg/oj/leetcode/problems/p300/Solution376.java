package cn.wsg.oj.leetcode.problems.p300;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 376. Wiggle Subsequence (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/wiggle-subsequence/">Wiggle Subsequence</a>
 */
class Solution376 implements Solution {

    /**
     * @see #DYNAMIC_PROGRAMMING
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public int wiggleMaxLength(int[] nums) {
        int[] dp = new int[nums.length];
        int positive = 0, negative = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[negative] + 1;
                positive = i;
            } else if (nums[i] < nums[i - 1]) {
                dp[i] = dp[positive] + 1;
                negative = i;
            }
        }
        return Math.max(dp[positive], dp[negative]) + 1;
    }
}
