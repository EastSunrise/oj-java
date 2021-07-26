package wsg.oj.java.leetcode.problems.p300;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p600.Solution646;
import wsg.oj.java.leetcode.problems.p600.Solution673;

/**
 * 300. Longest Increasing Subsequence (Medium)
 *
 * @author Kingen
 * @see Solution334
 * @see Solution354
 * @see Solution646
 * @see Solution673
 * @see Solution712
 * @see Solution1671
 * @see <a href="https://leetcode-cn.com/problems/longest-increasing-subsequence/">Longest
 * Increasing Subsequence</a>
 * @since 2021-07-04
 */
public class Solution300 implements Solution {

    /**
     * @see #DYNAMIC_PROGRAMMING
     * @see wsg.oj.java.Complexity#TIME_N_LOG_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int lengthOfLIS(int[] nums) {
        // dp[i]: the min of the last numbers of increasing subsequences with the length of i
        List<Integer> dp = new ArrayList<>();
        for (int num : nums) {
            int j = Collections.binarySearch(dp, num);
            if (j < 0) {
                j = -j - 1;
            }
            if (j == dp.size()) {
                dp.add(num);
            } else {
                dp.set(j, num);
            }
        }
        return dp.size();
    }

    /**
     * @see #DYNAMIC_PROGRAMMING
     * @see wsg.oj.java.Complexity#TIME_NN
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int lengthOfLIS2(int[] nums) {
        int n = nums.length;
        // dp[i]: the longest increasing subsequence that ends with nums[i]
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i]++;
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
