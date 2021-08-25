package wsg.oj.java.leetcode.problems.p700;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p200.Solution209;

/**
 * 718. Maximum Length of Repeated Subarray (MEDIUM)
 *
 * @author Kingen
 * @see Solution209
 * @see <a href="https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/">Maximum
 * Length of Repeated Subarray</a>
 * @since 2021-07-27
 */
public class Solution718 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_MN
     * @see wsg.oj.java.Complexity#SPACE_MN
     */
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
