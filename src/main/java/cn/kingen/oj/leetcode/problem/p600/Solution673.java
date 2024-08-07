package cn.kingen.oj.leetcode.problem.p600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/number-of-longest-increasing-subsequence/">673. Number of Longest Increasing Subsequence</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p300.Solution300
 * @see cn.kingen.oj.leetcode.problem.p600.Solution674
 */
@Question(
        tags = {Tag.BINARY_INDEXED_TREE, Tag.SEGMENT_TREE, Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.MEDIUM
)
public class Solution673 {

    @Complexity(time = "O(n^2)", space = "O(n)")
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