package wsg.oj.java.leetcode.problems.p1000;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p0.Solution72;

/**
 * 1035. Uncrossed Lines (MEDIUM)
 *
 * @author Kingen
 * @see Solution72
 * @see <a href="https://leetcode-cn.com/problems/uncrossed-lines/">Uncrossed Lines</a>
 * @since 2021-07-27
 */
public class Solution1035 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_MN
     * @see wsg.oj.java.Complexity#SPACE_MN
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        // dp[i][j]: the lines between nums1[0,i-1] and nums[0,j-1]
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
