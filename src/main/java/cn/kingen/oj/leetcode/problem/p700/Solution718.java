package cn.kingen.oj.leetcode.problem.p700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/maximum-length-of-repeated-subarray/">718. Maximum Length of Repeated Subarray</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution209
 */
@Question(
        tags = {Tag.ARRAY, Tag.BINARY_SEARCH, Tag.DYNAMIC_PROGRAMMING, Tag.SLIDING_WINDOW, Tag.HASH_FUNCTION, Tag.ROLLING_HASH},
        difficulty = Difficulty.MEDIUM
)
public class Solution718 {

    @Complexity(time = "O(m*n)", space = "O(m*n)")
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        // dp[i][j]: the longest common subarray that ends with nums1[i-1] and nums2[j-1]
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }
}