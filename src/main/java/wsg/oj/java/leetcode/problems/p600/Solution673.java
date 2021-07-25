package wsg.oj.java.leetcode.problems.p600;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p300.Solution300;

/**
 * 673. Number of Longest Increasing Subsequence (MEDIUM)
 *
 * @author Kingen
 * @see Solution300
 * @see Solution674
 * @see <a href="https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence/">Number
 * of Longest Increasing Subsequence</a>
 * @since 2021-07-23
 */
class Solution673 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_NN
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        // dp[i]: the length of the longest increasing subsequence that ends with nums[i]
        int[] dp = new int[n];
        // counts[i]: the count of the longest increasing subsequences that ends with nums[i]
        int[] counts = new int[n];
        dp[0] = counts[0] = 1;
        int longest = 1, total = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = counts[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    // update dp[i] and its count
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        counts[i] = counts[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        counts[i] += counts[j];
                    }
                }
            }
            // update the longest subsequence and its count
            if (dp[i] > longest) {
                longest = dp[i];
                total = counts[i];
            } else if (dp[i] == longest) {
                total += counts[i];
            }
        }
        return total;
    }
}
