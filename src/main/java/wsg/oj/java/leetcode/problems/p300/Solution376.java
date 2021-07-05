package wsg.oj.java.leetcode.problems.p300;

import wsg.oj.java.leetcode.problems.Solution;

/**
 * 376. Wiggle Subsequence (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/wiggle-subsequence/">Wiggle Subsequence</a>
 * @since 2021-07-04
 */
class Solution376 extends Solution {

    /**
     * @see #DYNAMIC_PROGRAMMING
     * @see #TIME_N
     * @see #SPACE_N
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
